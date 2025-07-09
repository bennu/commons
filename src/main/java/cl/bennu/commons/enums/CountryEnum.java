package cl.bennu.commons.enums;

import cl.bennu.commons.enums.base.BaseEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

/**
 * Represents a country with its associated details.
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CountryEnum implements BaseEnum {

    //@formatter:off
    AFGHANISTAN (1, "AFG", "Afganistán", 1919, CurrencyEnum.AFGHANI)
    , ALBANIA (2, "ALB", "Albania", 1912, CurrencyEnum.ALBANIAN_LEK)
    , ALGERIA (3, "DZA", "Argelia", 1962, CurrencyEnum.ALGERIAN_DINAR)
    , ANDORRA (4, "AND", "Andorra", 1278, CurrencyEnum.EURO)
    , ANGOLA (5, "AGO", "Angola", 1975, CurrencyEnum.ANGOLAN_KWANZA)
    , ANTIGUA_AND_BARBUDA (6, "ATG", "Antigua y Barbuda", 1981, CurrencyEnum.GRENADINE_DOLLAR)
    , ARGENTINA (7, "ARG", "Argentina", 1816, CurrencyEnum.ARGENTINIAN_PESO)
    , ARMENIA (8, "ARM", "Armenia", 1991, CurrencyEnum.ARMENIAN_DRAM)
    , AUSTRALIA (9, "AUS", "Australia", 1901, CurrencyEnum.AUSTRALIAN_DOLLAR)
    , AUSTRIA (10, "AUT", "Austria", 1955, CurrencyEnum.EURO)
    , AZERBAIJAN (11, "AZE", "Azerbaiyán", 1991, CurrencyEnum.AZERBAIJANI_MANAT)
    , BAHAMAS (12, "BHS", "Bahamas", 1973, CurrencyEnum.BAHAMIAN_DOLLAR)
    , BAHRAIN (13, "BHR", "Baréin", 1971, CurrencyEnum.BAHRAINI_DINAR)
    , BANGLADESH (14, "BGD", "Bangladés", 1971, CurrencyEnum.BANGLADESHI_TAKA)
    , BARBADOS (15, "BRB", "Barbados", 1966, CurrencyEnum.BARBADOS_DOLLAR)
    , BELARUS (16, "BLR", "Bielorrusia", 1991, CurrencyEnum.BELARUSIAN_RUBLE)
    , BELGIUM (17, "BEL", "Bélgica", 1830, CurrencyEnum.EURO)
    , BELIZE (18, "BLZ", "Belice", 1981, CurrencyEnum.BELIZE_DOLLAR)
    , BENIN (19, "BEN", "Benín", 1960, CurrencyEnum.SENEGAL_FRANC)
    , BHUTAN (20, "BTN", "Bután", 1907, CurrencyEnum.BHUTANESE_NGULTRUM)
    , BOLIVIA (21, "BOL", "Bolivia", 1825, CurrencyEnum.BOLIVIANO)
    , BOSNIA_AND_HERZEGOVINA (22, "BIH", "Bosnia y Herzegovina", 1992, CurrencyEnum.CONVERTIBLE_MARK)
    , BOTSWANA (23, "BWA", "Botsuana", 1966, CurrencyEnum.BOTSWANAN_PULA)
    , BRAZIL (24, "BRA", "Brasil", 1822, CurrencyEnum.BRAZILIAN_REAL)
    , BRUNEI (25, "BRN", "Brunéi", 1984, CurrencyEnum.BRUNEI_DOLLAR)
    , BULGARIA (26, "BGR", "Bulgaria", 1908, CurrencyEnum.BULGARIAN_LEV)
    , BURKINA_FASO (27, "BFA", "Burkina Faso", 1960, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , BURUNDI (28, "BDI", "Burundi", 1962, CurrencyEnum.BURUNDI_FRANC)
    , CABO_VERDE (29, "CPV", "Cabo Verde", 1975, CurrencyEnum.CAPE_VERDE_ESCUDO)
    , CAMBODIA (30, "KHM", "Camboya", 1953, CurrencyEnum.CAMBODIAN_RIEL)
    , CAMEROON (31, "CMR", "Camerún", 1960, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , CANADA (32, "CAN", "Canadá", 1867, CurrencyEnum.CANADIAN_DOLLAR)
    , CENTRAL_AFRICAN_REPUBLIC (33, "CAF", "República Centroafricana", 1960, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , CHAD (34, "TCD", "Chad", 1960, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , CHILE (35, "CHL", "Chile", 1818, CurrencyEnum.CHILEAN_PESO)
    , CHINA (36, "CHN", "China", 1949, CurrencyEnum.CHINESE_YUAN)
    , COLOMBIA (37, "COL", "Colombia", 1810, CurrencyEnum.COLOMBIAN_PESO)
    , COMOROS (38, "COM", "Comoras", 1975, CurrencyEnum.COMORIAN_FRANC)
    , CONGO_BRAZZAVILLE (39, "COG", "Congo (Rep. del Congo)", 1960, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , CONGO_KINSHASA (40, "COD", "República Democrática del Congo", 1960, CurrencyEnum.CONGOLESE_FRANC)
    , COSTA_RICA (41, "CRI", "Costa Rica", 1821, CurrencyEnum.COSTA_RICA_COLON)
    , CROATIA (42, "HRV", "Croacia", 1991, CurrencyEnum.CROATIAN_KUNA)
    , CUBA (43, "CUB", "Cuba", 1902, CurrencyEnum.CUBAN_PESO)
    , CYPRUS (44, "CYP", "Chipre", 1960, CurrencyEnum.CYPRIOT_POUND)
    , CZECH_REPUBLIC (45, "CZE", "República Checa", 1993, CurrencyEnum.CZECH_KORUNA)
    , DENMARK (46, "DNK", "Dinamarca", 1814, CurrencyEnum.DANISH_KRONE)
    , DJIBOUTI (47, "DJI", "Yibuti", 1977, CurrencyEnum.DJIBOUTIAN_FRANC)
    , DOMINICA (48, "DMA", "Dominica", 1978, CurrencyEnum.US_DOLLAR)
    , DOMINICAN_REPUBLIC (49, "DOM", "República Dominicana", 1844, CurrencyEnum.DOMINICAN_PESO)
    , ECUADOR (50, "ECU", "Ecuador", 1830, CurrencyEnum.US_DOLLAR)
    , EGYPT (51, "EGY", "Egipto", 1952, CurrencyEnum.EGYPTIAN_POUND)
    , EL_SALVADOR (52, "SLV", "El Salvador", 1821, CurrencyEnum.EL_SALVADOR_COLON)
    , EQUATORIAL_GUINEA (53, "GNQ", "Guinea Ecuatorial", 1968, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , ERITREA (54, "ERI", "Eritrea", 1993, CurrencyEnum.ERITREAN_NAKFA)
    , ESTONIA (55, "EST", "Estonia", 1991, CurrencyEnum.EURO)
    , ESWATINI (56, "SWZ", "Esuatini", 1968, CurrencyEnum.SWAZI_LILANGENI)
    , ETHIOPIA (57, "ETH", "Etiopía", 1941, CurrencyEnum.ETHIOPIAN_BIRR)
    , FIJI (58, "FJI", "Fiyi", 1970, CurrencyEnum.FIJI_DOLLAR)
    , FINLAND (59, "FIN", "Finlandia", 1917, CurrencyEnum.EURO)
    , FRANCE (60, "FRA", "Francia", 843, CurrencyEnum.EURO)
    , GABON (61, "GAB", "Gabón", 1960, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , GAMBIA (62, "GMB", "Gambia", 1965, CurrencyEnum.GAMBIA_DALASI)
    , GEORGIA (63, "GEO", "Georgia", 1991, CurrencyEnum.GEORGIAN_LARI)
    , GERMANY (64, "DEU", "Alemania", 1871, CurrencyEnum.EURO)
    , GHANA (65, "GHA", "Ghana", 1960, CurrencyEnum.GHANAIAN_CEDI)
    , GREECE (66, "GRC", "Grecia", 1821, CurrencyEnum.EURO)
    , GRENADA (67, "GRD", "Granada", 1974, CurrencyEnum.GRENADINE_DOLLAR)
    , GUATEMALA (68, "GTM", "Guatemala", 1821, CurrencyEnum.GUATEMALAN_QUETZAL)
    , GUINEA (69, "GIN", "Guinea", 1958, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , GUINEA_BISSAU (70, "GNB", "Guinea-Bisáu", 1973, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , GUYANA (71, "GUY", "Guyana", 1966, CurrencyEnum.GUYANESE_DOLLAR)
    , HAITI (72, "HTI", "Haití", 1804, CurrencyEnum.HAITIAN_GOURDE)
    , HONDURAS (73, "HND", "Honduras", 1821, CurrencyEnum.HONDURAN_LEMPIRA)
    , HUNGARY (74, "HUN", "Hungría", 1989, CurrencyEnum.HUNGARIAN_FORINT)
    , ICELAND (75, "ISL", "Islandia", 1944, CurrencyEnum.ICELANDIC_KRONA)
    , INDIA (76, "IND", "India", 1947, CurrencyEnum.INDIAN_RUPEE)
    , INDONESIA (77, "IDN", "Indonesia", 1945, CurrencyEnum.INDONESIAN_RUPIAH)
    , IRAN (78, "IRN", "Irán", 1979, CurrencyEnum.IRANIAN_RIAL)
    , IRAQ (79, "IRQ", "Irak", 1932, CurrencyEnum.IRAQI_DINAR)
    , IRELAND (80, "IRL", "Irlanda", 1922, CurrencyEnum.EURO)
    , ISRAEL (81, "ISR", "Israel", 1948, CurrencyEnum.ISRAELI_NEW_SHEKEL)
    , ITALY (82, "ITA", "Italia", 1861, CurrencyEnum.EURO)
    , JAMICA (83, "JAM", "Jamaica", 1962, CurrencyEnum.JAMICAN_DOLLAR)
    , JAPAN (84, "JPN", "Japón", 660, CurrencyEnum.JAPANESE_YEN)
    , JORDAN (85, "JOR", "Jordania", 1946, CurrencyEnum.JORDANIAN_DINAR)
    , KAZAKHSTAN (86, "KAZ", "Kazajistán", 1991, CurrencyEnum.KAZAKHSTANI_TENGE)
    , KENYA (87, "KEN", "Kenia", 1963, CurrencyEnum.KENYAN_SHILLING)
    , KIRIBATI (88, "KIR", "Kiribati", 1979, CurrencyEnum.AUSTRALIAN_DOLLAR)
    , KOREA_NORTH (89, "PRK", "Corea del Norte", 1948, CurrencyEnum.NORTH_KOREAN_WON)
    , KOREA_SOUTH (90, "KOR", "Corea del Sur", 1948, CurrencyEnum.KOREAN_WON)
    , KUWAIT (91, "KWT", "Kuwait", 1961, CurrencyEnum.KUWAITI_DINAR)
    , KYRGYZSTAN (92, "KGZ", "Kirguistán", 1991, CurrencyEnum.KYRGYZSTANI_SOM)
    , LAOS (93, "LAO", "Laos", 1954, CurrencyEnum.LAOTIAN_KIP)
    , LATVIA (94, "LVA", "Letonia", 1991, CurrencyEnum.EURO)
    , LEBANON (95, "LBN", "Líbano", 1943, CurrencyEnum.LEBANESE_POUND)
    , LESOTHO (96, "LSO", "Lesoto", 1966, CurrencyEnum.LESOTHO_LOTI)
    , LIBERIA (97, "LBR", "Liberia", 1847, CurrencyEnum.LIBERIAN_DOLLAR)
    , LIBYA (98, "LBY", "Libia", 1951, CurrencyEnum.LIBYAN_DINAR)
    , LIECHTENSTEIN (99, "LIE", "Liechtenstein", 1806, CurrencyEnum.SWISS_FRANC)
    , LITHUANIA (100, "LTU", "Lituania", 1990, CurrencyEnum.EURO)
    , LUXEMBOURG (101, "LUX", "Luxemburgo", 1839, CurrencyEnum.EURO)
    , MADAGASCAR (102, "MDG", "Madagascar", 1960, CurrencyEnum.MALAGASY_ARIARY)
    , MALAWI (103, "MWL", "Malaui", 1964, CurrencyEnum.MALAWIAN_KWACHA)
    , MALAYSIA (104, "MYS", "Malasia", 1957, CurrencyEnum.MALAYSIAN_RINGGIT)
    , MALDIVES (105, "MDV", "Maldivas", 1965, CurrencyEnum.MALDIVIAN_RUFIYAA)
    , MALI (106, "MLI", "Malí", 1960, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , MALTA (107, "MLT", "Malta", 1964, CurrencyEnum.EURO)
    , MARSHALL_ISLANDS (108, "MHL", "Islas Marshall", 1986, CurrencyEnum.US_DOLLAR)
    , MAURITANIA (109, "MRT", "Mauritania", 1960, CurrencyEnum.MAURITANIAN_OUGUIYA)
    , MAURITIUS (110, "MUS", "Mauricio", 1968, CurrencyEnum.MAURITIAN_RUPEE)
    , MEXICO (111, "MEX", "México", 1810, CurrencyEnum.MEXICAN_PESO)
    , MICRONESIA (112, "FSM", "Micronesia", 1986, CurrencyEnum.US_DOLLAR)
    , MOLDOVA (113, "MDA", "Moldavia", 1991, CurrencyEnum.MOLDOVAN_LEU)
    , MONACO (114, "MCO", "Mónaco", 1297, CurrencyEnum.EURO)
    , MONGOLIA (115, "MNG", "Mongolia", 1921, CurrencyEnum.MONGOLIAN_TUGRIK)
    , MONTENEGRO (116, "MNE", "Montenegro", 2006, CurrencyEnum.EURO)
    , MOROCCO (117, "MAR", "Marruecos", 1956, CurrencyEnum.MOROCCAN_DIRHAM)
    , MOZAMBIQUE (118, "MOZ", "Mozambique", 1975, CurrencyEnum.MOZAMBICAN_METICAL)
    , MYANMAR (119, "MMR", "Birmania", 1948, CurrencyEnum.MYANMAR_KYAT)
    , NAMIBIA (120, "NAM", "Namibia", 1990, CurrencyEnum.NAMIBIAN_DOLLAR)
    , NAURU (121, "NRU", "Naurú", 1968, CurrencyEnum.AUSTRALIAN_DOLLAR)
    , NEPAL (122, "NPL", "Nepal", 1951, CurrencyEnum.NEPALESE_RUPEE)
    , NETHERLANDS (123, "NLD", "Países Bajos", 1579, CurrencyEnum.EURO)
    , NEW_ZEALAND (124, "NZL", "Nueva Zelanda", 1907, CurrencyEnum.NEW_ZEALAND_DOLLAR)
    , NICARAGUA (125, "NIC", "Nicaragua", 1821, CurrencyEnum.NICARAGUAN_CORDOBA)
    , NIGER (126, "NER", "Níger", 1960, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , NIGERIA (127, "NGA", "Nigeria", 1960, CurrencyEnum.NIGERIAN_NAIRA)
    , NORTH_MACEDONIA (128, "MKD", "Macedonia del Norte", 1991, CurrencyEnum.MACEDONIAN_DENAR)
    , NORWAY (129, "NOR", "Noruega", 1905, CurrencyEnum.NORWEGIAN_KRONE)
    , OMAN (130, "OMN", "Omán", 1971, CurrencyEnum.OMANI_RIAL)
    , PAKISTAN (131, "PAK", "Pakistán", 1947, CurrencyEnum.PAKISTANI_RUPEE)
    , PALAU (132, "PLW", "Palaos", 1994, CurrencyEnum.US_DOLLAR)
    , PANAMA (133, "PAN", "Panamá", 1903, CurrencyEnum.PANAMANIAN_BALBOA)
    , PAPUA_NEW_GUINEA (134, "PNG", "Papúa Nueva Guinea", 1975, CurrencyEnum.PAPUA_NEW_GUINEA_KINA)
    , PARAGUAY (135, "PRY", "Paraguay", 1811, CurrencyEnum.PARAGUAYAN_GUARANI)
    , PERU (136, "PER", "Perú", 1821, CurrencyEnum.PERUVIAN_NUEVO_SOL)
    , PHILIPPINES (137, "PHL", "Filipinas", 1946, CurrencyEnum.PHILIPPINE_PESO)
    , POLAND (138, "POL", "Polonia", 1989, CurrencyEnum.POLISH_ZLOTY)
    , PORTUGAL (139, "PRT", "Portugal", 1143, CurrencyEnum.EURO)
    , QATAR (140, "QAT", "Catar", 1971, CurrencyEnum.QATAR_RIAL)
    , ROMANIA (141, "ROU", "Rumanía", 1877, CurrencyEnum.ROMANIAN_LEU)
    , RUSSIA (142, "RUS", "Rusia", 1991, CurrencyEnum.RUSSIAN_ROUBLE)
    , RWANDA (143, "RWA", "Ruanda", 1962, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , SAINT_KITTS_AND_NEVIS (144, "KNA", "San Cristóbal y Nieves", 1983, CurrencyEnum.GRENADINE_DOLLAR)
    , SAINT_LUCIA (145, "LCA", "Santa Lucía", 1979, CurrencyEnum.GRENADINE_DOLLAR)
    , SAINT_VINCENT_AND_GRENADINES (146, "VCT", "San Vicente y las Granadinas", 1979, CurrencyEnum.GRENADINE_DOLLAR)
    , SAMOA (147, "SMO", "Samoa", 1962, CurrencyEnum.SAMOAN_TALA)
    , SAN_MARINO (148, "SMR", "San Marino", 301, CurrencyEnum.EURO)
    , SAO_TOME_AND_PRINCIPE (149, "STP", "Santo Tomé y Príncipe", 1975, CurrencyEnum.SAO_TOME_AND_PRINCIPE_DOBRA)
    , SAUDI_ARABIA (150, "SAU", "Arabia Saudita", 1932, CurrencyEnum.SAUDI_RIAL)
    , SENEGAL (151, "SEN", "Senegal", 1960, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , SERBIA (152, "SRB", "Serbia", 2006, CurrencyEnum.SERBIAN_DINAR)
    , SEYCHELLES (153, "SYC", "Seychelles", 1976, CurrencyEnum.SEYCHELLOIS_RUPEE)
    , SIERRA_LEONE (154, "SLE", "Sierra Leona", 1961, CurrencyEnum.SIERRA_LEONEAN_LEONE)
    , SINGAPORE (155, "SGP", "Singapur", 1965, CurrencyEnum.SINGAPORE_DOLLAR)
    , SINT_MAARTEN (156, "SXM", "Sint Maarten", 2010, CurrencyEnum.NETHERLANDS_ANTILLEAN_GUILDER)
    , SLOVAKIA (157, "SVK", "Eslovaquia", 1993, CurrencyEnum.EURO)
    , SLOVENIA (158, "SVN", "Eslovenia", 1991, CurrencyEnum.EURO)
    , SOLOMON_ISLANDS (159, "SLB", "Islas Salomón", 1978, CurrencyEnum.AUSTRALIAN_DOLLAR)
    , SOMALIA (160, "SOM", "Somalia", 1960, CurrencyEnum.SOMALI_SHILLING)
    , SOUTH_AFRICA (161, "ZAF", "Sudáfrica", 1994, CurrencyEnum.SOUTH_AFRICAN_RAND)
    , SOUTH_SUDAN (162, "SSD", "Sudán del Sur", 2011, CurrencyEnum.SOUTH_SUDANESE_POUND)
    , SPAIN (163, "ESP", "España", 1492, CurrencyEnum.EURO)
    , SRI_LANKA (164, "LKA", "Sri Lanka", 1948, CurrencyEnum.SRI_LANKAN_RUPEE)
    , SUDAN (165, "SDN", "Sudán", 1956, CurrencyEnum.SUDANESE_POUND)
    , SURINAME (166, "SUR", "Surinam", 1975, CurrencyEnum.SURINAME_DOLLAR)
    , SWEDEN (167, "SWE", "Suecia", 1523, CurrencyEnum.SWEDISH_KRONA)
    , SWITZERLAND (168, "CHE", "Suiza", 1291, CurrencyEnum.SWISS_FRANC)
    , SYRIA (169, "SYR", "Siria", 1946, CurrencyEnum.SYRIAN_POUND)
    , TAIWAN (170, "TWN", "Taiwán", 1949, CurrencyEnum.TAIWANESE_NEW_DOLLAR)
    , TAJIKISTAN (171, "TJK", "Tayikistán", 1991, CurrencyEnum.TAJIKISTANI_SOMONI)
    , TANZANIA (172, "TZA", "Tanzania", 1961, CurrencyEnum.TANZANIAN_SHILLING)
    , THAILAND (173, "THA", "Tailandia", 1932, CurrencyEnum.BAHT)
    , TOGO (174, "TGO", "Togo", 1960, CurrencyEnum.BURKINA_FASO_CFA_FRANC)
    , TONGA (175, "TON", "Tonga", 1970, CurrencyEnum.TONGAN_PAANGA)
    , TRINIDAD_AND_TOBAGO (176, "TTO", "Trinidad y Tobago", 1962, CurrencyEnum.TRINIDAD_AND_TOBAGO_DOLLAR)
    , TUNISIA (177, "TUN", "Túnez", 1956, CurrencyEnum.TUNISIAN_DINAR)
    , TURKMENISTAN (178, "TKM", "Turkmenistán", 1991, CurrencyEnum.TURKMENISTANI_MANAT)
    , TURKEY (179, "TUR", "Turquía", 1923, CurrencyEnum.TURKISH_LIRA)
    , TUVALU (180, "TUV", "Tuvalu", 1978, CurrencyEnum.AUSTRALIAN_DOLLAR)
    , UGANDA (181, "UGA", "Uganda", 1962, CurrencyEnum.UGANDA_SHILLING)
    , UKRAINE (182, "UKR", "Ucrania", 1991, CurrencyEnum.UKRAINE_HRYVNIA)
    , UNITED_ARAB_EMIRATES (183, "ARE", "Emiratos Árabes Unidos", 1971, CurrencyEnum.EMIRATI_DIRHAM)
    , UNITED_KINGDOM (184, "GBR", "Reino Unido", 1707, CurrencyEnum.BRITISH_POUND)
    , UNITED_STATES (185, "USA", "Estados Unidos", 1776, CurrencyEnum.US_DOLLAR)
    , URUGUAY (186, "URY", "Uruguay", 1830, CurrencyEnum.URUGUAYAN_PESO)
    , UZBEKISTAN (187, "UZB", "Uzbekistán", 1991, CurrencyEnum.UZBEKISTANI_SOM)
    , VANUATU (188, "VUT", "Vanuatu", 1980, CurrencyEnum.VANUATU_VAT)
    , VATICAN_CITY (189, "VAT", "Ciudad del Vaticano", 1929, CurrencyEnum.EURO)
    , VENEZUELA (190, "VEN", "Venezuela", 1811, CurrencyEnum.VENEZUELAN_BOLÍVAR)
    , VIETNAM (191, "VNM", "Vietnam", 1945, CurrencyEnum.VIETNAMESE_DONG)
    , YEMEN (192, "YEM", "Yemen", 1967, CurrencyEnum.YEMENI_RIAL)
    , ZAMBIA (193, "ZMB", "Zambia", 1964, CurrencyEnum.ZAMBIAN_KWACHA)
    , ZIMBABWE (194, "ZWE", "Zimbabue", 1980, CurrencyEnum.ZIMBABWEAN_DOLLAR)
    ;
    //@formatter:on

    /**
     * Constructor for CountryEnum.
     *
     * @param id the unique identifier of the country
     * @param code the ISO code of the country
     * @param name the name of the country
     * @param independenceYear the year of independence
     * @param currencyEnum the associated currency
     */
    CountryEnum(Integer id, String code, String name, Integer independenceYear, CurrencyEnum currencyEnum) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.independenceYear = independenceYear;
        this.currencyEnum = currencyEnum;
    }

    private final Integer id;
    private final String code;
    private final String name;
    private final Integer independenceYear;
    private final CurrencyEnum currencyEnum;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CountryEnum valueOf(Object o) {
        if (o instanceof Integer id) {
            return Arrays.stream(values()).filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        } else if (o instanceof Map map) {
            Integer id = (Integer) map.get("id");
            return Arrays.stream(values()).filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        } else {
            return null;
        }
    }

}
