package com.example.homecommerce.model

import com.example.homecommerce.ext.getDefault
import com.google.gson.annotations.SerializedName

class FeedbackData(
    val generalFeedbackInfo: GeneralFeedbackInfo? = null,
    val feedbacks: List<Feedback>? = null
) {
    class GeneralFeedbackInfo(
        val averageFeedbackRate: Double? = null,
        val totalFeedback: Int? = null,
        @SerializedName("totalByComment")
        val commentCount: Int? = null,
        @SerializedName("totalByMedia")
        val mediaCount: Int? = null,
        val totalByStar: List<TotalByStar>? = null
    ) {
        class TotalByStar(
            @SerializedName("vote_star")
            val voteStar: Int? = null,
            val total: Int? = null
        )

        fun getStart5Count(): Int {
            return totalByStar?.find { it.voteStar == 5 }?.total.getDefault()
        }

        fun getStart4Count(): Int {
            return totalByStar?.find { it.voteStar == 4 }?.total.getDefault()
        }

        fun getStart3Count(): Int {
            return totalByStar?.find { it.voteStar == 3 }?.total.getDefault()
        }

        fun getStart2Count(): Int {
            return totalByStar?.find { it.voteStar == 2 }?.total.getDefault()
        }

        fun getStart1Count(): Int {
            return totalByStar?.find { it.voteStar == 1 }?.total.getDefault()
        }
    }
}