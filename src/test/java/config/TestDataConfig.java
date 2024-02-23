package config;

import org.aeonbits.owner.Config;

    public interface TestDataConfig extends Config {
        @Key("popularCity")
        @DefaultValue("Rome")
        String getPopularCity();
}
