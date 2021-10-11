package com.example.homecommerce.shared

import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

class AppManagerStateChangeObs @Inject constructor(){

    val chatManagerStageObs = PublishSubject.create<ChatManagerState>()
    val productManagerStageObs = PublishSubject.create<ProductManagerStage>()
    val userManagerStageObs = PublishSubject.create<UserManagerState>()

    sealed class ChatManagerState {
        object UpdateBadge : ChatManagerState()
    }

    sealed class ProductManagerStage {
        class LikeStage(val productId: String, val isLike: Boolean) : ProductManagerStage()
    }

    sealed class UserManagerState {
        class FollowUserState(val userId: String, val isFollow: Boolean) : UserManagerState()
    }

}