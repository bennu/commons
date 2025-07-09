package cl.bennu.commons.twofactor.iface;

public interface TwoFactor {

    String generate();

    String generate(Integer length);

}
