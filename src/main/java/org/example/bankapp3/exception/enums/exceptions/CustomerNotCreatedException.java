package org.example.bankapp3.exception.enums.exceptions;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.bankapp3.enums.Language;
import org.example.bankapp3.exception.enums.IFriendlyMessageCode;
import org.example.bankapp3.exception.enums.utils.FriendlyMessageUtils;

@Slf4j
@Getter
public class CustomerNotCreatedException extends RuntimeException{
    private final Language language;
    private final IFriendlyMessageCode friendlyMessageCode;

    public CustomerNotCreatedException(Language language, IFriendlyMessageCode friendlyMessageCode, String message) {
        super(FriendlyMessageUtils.getFriendlyMessage(language,friendlyMessageCode));
        this.language = language;
        this.friendlyMessageCode = friendlyMessageCode;
        log.error("[CustomerNotCreatedException] -> message: {} developer message: {}",FriendlyMessageUtils.getFriendlyMessage(language,friendlyMessageCode),message);
    }
}
