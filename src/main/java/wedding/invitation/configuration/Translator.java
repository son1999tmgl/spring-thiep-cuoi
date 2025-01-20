package wedding.invitation.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class Translator {
    private static ResourceBundleMessageSource messageSource;
    @Autowired
    public Translator(ResourceBundleMessageSource messageSource){
        Translator.messageSource = messageSource;
    }
    public static String toLocale(String msgCode){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgCode, null, locale);
    }
}
