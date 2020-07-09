package com.buyalskaya.bookstorage.controller.command;

public enum CommandName {
    ADD("add"),
    REMOVE("remove"),
    FIND_BY_ID("findById"),
    FIND_BY_NAME("findByName"),
    FIND_BY_AUTHOR("findByAuthor"),
    FIND_BY_EDITION("findByEdition"),
    FIND_BY_YEAR("findByYear"),
    FIND_BY_PAGE("findByPage"),
    SORT_BY_ID("sortById"),
    SORT_BY_NAME("sortByName"),
    SORT_BY_AUTHOR("sortByAuthor"),
    SORT_BY_EDITION("sortByEdition"),
    SORT_BY_YEAR("sortByYear"),
    SORT_BY_PAGE("sortByPage");

    private String commandStringName;

    CommandName(String commandStringName) {
        this.commandStringName = commandStringName;
    }

    public String getCommandStringName() {
        return commandStringName;
    }
}
