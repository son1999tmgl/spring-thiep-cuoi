package wedding.invitation.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


@Component
@Configuration
public class I18nConfig implements LocaleResolver
{
    private final List<Locale> SUPPORTED_LOCALES = Arrays.asList(
            Locale.ENGLISH,
            new Locale("vi"),
            Locale.FRENCH
    );
    private final Locale DEFAULT_LOCALE = new Locale("vi");
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

    public String messageSource(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource.getMessage(code, null, locale);
    }
}
