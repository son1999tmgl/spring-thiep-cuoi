package wedding.invitation.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
public class i18nConfig implements LocaleResolver
{
    private static final List<Locale> SUPPORTED_LOCALES = Arrays.asList(
            Locale.ENGLISH,
            new Locale("vi"), // Tiếng Việt
            Locale.FRENCH     // Tiếng Pháp
    );
    private static final Locale DEFAULT_LOCALE = new Locale("vi");
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String acceptLanguage = request.getHeader("Accept-Language");
        if (!StringUtils.hasText(acceptLanguage)) {
            return DEFAULT_LOCALE;
        }
        String language = acceptLanguage.split(",")[0];
        for (Locale locale : SUPPORTED_LOCALES) {
            if (locale.getLanguage().equals(new Locale(language).getLanguage())) {
                return locale;
            }
        }
        return DEFAULT_LOCALE;
    }
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
    @Bean
    public LocaleResolver localeResolver() {
        return new i18nConfig();
    }

    @Bean
    public MessageSource messageSource(String code) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
