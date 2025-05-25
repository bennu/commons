package cl.bennu.commons.number.iface;

public interface SpecificNumberSystem {

    String convert(Long number);

    String convert(long number);

    String convert(Integer number);

    String convert(int number);

    long convert(String value);

}
