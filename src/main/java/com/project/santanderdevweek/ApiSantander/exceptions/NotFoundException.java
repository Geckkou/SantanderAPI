package com.project.santanderdevweek.ApiSantander.exceptions;

import com.project.santanderdevweek.ApiSantander.util.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
