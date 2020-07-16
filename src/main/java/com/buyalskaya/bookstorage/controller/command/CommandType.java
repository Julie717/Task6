package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.*;

public enum CommandType {
    ADD(new AddCommand()),
    REMOVE_BY_ID(new RemoveByIdCommand()),
    FIND_ALL(new FindAllCommand()),
    FIND_BY_ID(new FindByIdCommand()),
    FIND_BY_NAME(new FindByNameCommand()),
    FIND_BY_AUTHOR(new FindByAuthorCommand()),
    FIND_BY_EDITION(new FindByEditionCommand()),
    FIND_BY_YEAR(new FindByYearCommand()),
    FIND_BY_PAGE(new FindByPageCommand()),
    SORT_BY_NAME(new SortByNameCommand()),
    SORT_BY_AUTHOR(new SortByAuthorCommand()),
    SORT_BY_EDITION(new SortByEditionCommand()),
    SORT_BY_YEAR(new SortByYearCommand()),
    SORT_BY_PAGE(new SortByPageCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}