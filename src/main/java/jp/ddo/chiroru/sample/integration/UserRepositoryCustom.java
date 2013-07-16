package jp.ddo.chiroru.sample.integration;

import java.util.List;

import jp.ddo.chiroru.sample.domain.User;

public interface UserRepositoryCustom {

    List<User> myCustomBatchOperation();
}
