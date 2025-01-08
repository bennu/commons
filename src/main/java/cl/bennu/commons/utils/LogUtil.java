package cl.bennu.commons.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogUtil {

    private LogUtil() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(LogUtil.class);

    static String callerClassName() {
        try {
            return "[" + Thread.currentThread().getStackTrace()[3].getClassName() + "] --- ";
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    public static void insert(String user, String entity, Object o) {
        if (StringUtils.isBlank(user)) {
            user = "anonymous";
        }

        String log = StringUtils.capitalize(entity)
                + " insert by "
                + user
                + ", data = "
                + ToStringBuilder.reflectionToString(o);

        LOGGER.info(callerClassName() + log);
    }

    public static void update(String user, String entity, Object oldO, Object newO) {
        if (StringUtils.isBlank(user)) {
            user = "anonymous";
        }

        String log = StringUtils.capitalize(entity)
                + " update by "
                + user
                + ", old data = "
                + ToStringBuilder.reflectionToString(oldO)
                + ", new data = "
                + ToStringBuilder.reflectionToString(newO);

        LOGGER.info(callerClassName() + log);
    }

    public static void delete(String user, String entity, Object o) {
        if (StringUtils.isBlank(user)) {
            user = "anonymous";
        }

        String log = StringUtils.capitalize(entity)
                + " delete by "
                + user
                + ", data = "
                + ToStringBuilder.reflectionToString(o);

        LOGGER.info(callerClassName() + log);
    }

    public static void log(String log) {
        LOGGER.info(callerClassName() + log);
    }

    public static void log(String log, Object... objects) {
        StringBuilder stringBuilder = new StringBuilder(log);
        for (Object o : objects) {
            if (o instanceof String || o instanceof Number || o instanceof Boolean) {
                stringBuilder.append("    -> ").append(o);
            } else {
                stringBuilder.append("    -> ").append(ToStringBuilder.reflectionToString(o));
            }
        }

        LOGGER.info(callerClassName() + stringBuilder);
    }

    public static void log(String user, String log) {
        if (StringUtils.isBlank(user)) {
            user = "anonymous";
        }

        String logStr = "User "
                + user
                + StringUtils.SPACE
                + log;

        LOGGER.info(callerClassName() + logStr);
    }

    public static void error(String log, Exception e) {
        LOGGER.error(callerClassName() + log, e);
    }

}
