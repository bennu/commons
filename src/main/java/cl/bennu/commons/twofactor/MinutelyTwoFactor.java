package cl.bennu.commons.twofactor;

import cl.bennu.commons.enums.TwoFactorTypeEnum;
import cl.bennu.commons.twofactor.iface.TwoFactor;

public class MinutelyTwoFactor extends AbstractTwoFactor implements TwoFactor {

    @Override
    public String generate() {
        return generate(TwoFactorTypeEnum.MINUTELY, null);
    }

    @Override
    public String generate(Integer length) {
        return generate(TwoFactorTypeEnum.MINUTELY, length);
    }

}
