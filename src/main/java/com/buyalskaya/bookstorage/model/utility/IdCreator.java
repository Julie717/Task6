package com.buyalskaya.bookstorage.model.utility;

import java.util.UUID;

public class IdCreator {
    public static UUID createId() {
        return UUID.randomUUID();
    }
}
