package br.com.helberbelmiro.quarkus_test_util.db;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class RollingbackTransactionOnEachTest {

    private final UserTransaction userTransaction;

    protected RollingbackTransactionOnEachTest(UserTransaction userTransaction) {
        this.userTransaction = userTransaction;
    }

    @BeforeEach
    void setup() throws SystemException, NotSupportedException {
        this.userTransaction.begin();
    }

    @AfterEach
    void cleanup() throws SystemException {
        this.userTransaction.rollback();
    }

}
