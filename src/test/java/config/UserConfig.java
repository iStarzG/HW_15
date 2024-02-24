package config;
import org.aeonbits.owner.Config;



@Config.Sources("classpath:config/${environment}.properties")
public interface UserConfig extends Config {
        @DefaultValue("Elon")
        @Key("first.name")
        String firstName();

        @DefaultValue("Musk")
        @Key("last.name")
        String lastName();

        @DefaultValue("emusk@yandex.ru")
        @Key("user.email")
        String userEmail();

        @DefaultValue("1.jpeg")
        @Key("image.name")
        String imageName();


    }