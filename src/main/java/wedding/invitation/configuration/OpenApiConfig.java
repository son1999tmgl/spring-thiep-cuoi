package wedding.invitation.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devServer.getUrl());
        devServer.setDescription("Server URL in Development environment");

//        Server prodServer = new Server();
//        prodServer.setUrl(prodServer.getUrl());
//        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("son1999tmgl@gmail.com");
        contact.setName("SonNguyen");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("API thiệp cưới")
                .version("1.0")
                .contact(contact)
                .description("description")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }

}
