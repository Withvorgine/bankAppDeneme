package org.example.bankapp3.exception.enums;

public enum FriendlyMessageCodes implements IFriendlyMessageCode{
    OK(1000),
    ERROR(1001),
    CUSTOMER_NOT_CREATED_EXCEPTION(1500),
    CUSTOMER_SUCCESSFULLY_CREATED(1501);
    private final int value;

    FriendlyMessageCodes(int value){this.value=value;}



    @Override
    public int getFriendlyMessageCode() {
        return value;
    }
}
