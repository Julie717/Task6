package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.*;

public enum CommandType {
    ADD {
        {
            this.command = new AddCommand();
        }
    },
    REMOVE_BY_ID {
        {
            this.command = new RemoveByIdCommand();
        }
    },
    FIND_ALL {
        {
            this.command = new FindAllCommand();
        }
    },
    FIND_BY_ID {
        {
            this.command = new FindByIdCommand();
        }
    },
    FIND_BY_NAME {
        {
            this.command = new FindByNameCommand();
        }
    },
    FIND_BY_AUTHOR {
        {
            this.command = new FindByAuthorCommand();
        }
    },
    FIND_BY_EDITION {
        {
            this.command = new FindByEditionCommand();
        }
    },
    FIND_BY_YEAR {
        {
            this.command = new FindByYearCommand();
        }
    },
    FIND_BY_PAGE {
        {
            this.command = new FindByPageCommand();
        }
    },
    SORT_BY_NAME {
        {
            this.command = new SortByNameCommand();
        }
    },
    SORT_BY_AUTHOR {
        {
            this.command = new SortByAuthorCommand();
        }
    },
    SORT_BY_EDITION {
        {
            this.command = new SortByEditionCommand();
        }
    },
    SORT_BY_YEAR {
        {
            this.command = new SortByYearCommand();
        }
    },
    SORT_BY_PAGE {
        {
            this.command = new SortByPageCommand();
        }
    };

    Command command;

    public Command getCommand() {
        return command;
    }
}