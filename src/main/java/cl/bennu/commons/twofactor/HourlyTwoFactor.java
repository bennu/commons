package cl.bennu.commons.twofactor;

import cl.bennu.commons.enums.TwoFactorTypeEnum;
import cl.bennu.commons.twofactor.iface.TwoFactor;

public class HourlyTwoFactor extends AbstractTwoFactor implements TwoFactor {

    @Override
    public String generate() {
        return generate(TwoFactorTypeEnum.HOURLY, null);
    }

    @Override
    public String generate(Integer length) {
        return generate(TwoFactorTypeEnum.HOURLY, length);
    }

}
