package com.example.homecommerce.model.localized

import com.example.homecommerce.prefs.AppLanguage

/**
 * Created by pvduc9773 on 11/07/2021.
 */

fun String.getLocalized(appLanguage: AppLanguage): String {
    when (appLanguage) {
        AppLanguage.KOREAN -> {
            return when {
                // Size Detail
                this.equals("Chiều cao", true) -> "키"
                this.equals("Height", true) -> "키"

                this.equals("Cân nặng", true) -> "몸무게"
                this.equals("Weight", true) -> "몸무게"

                this.equals("Chiều dài áo", true) -> "상의 기장"
                this.equals("Length", true) -> "상의 기장"

                this.equals("Chiều dài quần", true) -> "하의 기장"
                this.equals("Outseam", true) -> "하의 기장"

                this.equals("Vai", true) -> "어깨"
                this.equals("Shoulder", true) -> "어깨"

                this.equals("Ngực", true) -> "가슴"
                this.equals("Chest", true) -> "가슴"

                this.equals("Eo", true) -> "허리"
                this.equals("Waist", true) -> "허리"

                this.equals("Hông", true) -> "엉덩이"
                this.equals("Hip", true) -> "엉덩이"

                this.equals("Đùi", true) -> "허벅지"
                this.equals("Thigh", true) -> "허벅지"

                this.equals("Kích cỡ", true) -> "사이즈"
                this.equals("Size", true) -> "사이즈"

                this.equals("Màu sắc", true) -> "색상"
                this.equals("Color", true) -> "색상"

                this.equals("Trắng", true) -> "화이트"
                this.equals("White", true) -> "화이트"

                this.equals("Đen", true) -> "블랙"
                this.equals("Black", true) -> "블랙"

                else -> this
            }
        }
        AppLanguage.ENGLISH -> {
            return when {
                this.equals("Chiều cao", true) -> "Height"
                this.equals("키", true) -> "Height"

                this.equals("Cân nặng", true) -> "Weight"
                this.equals("몸무게", true) -> "Weight"

                this.equals("Chiều dài áo", true) -> "Length"
                this.equals("상의 기장", true) -> "Length"

                this.equals("Chiều dài quần", true) -> "Outseam"
                this.equals("하의 기장", true) -> "Outseam"

                this.equals("Vai", true) -> "Shoulder"
                this.equals("어깨", true) -> "Shoulder"

                this.equals("Ngực", true) -> "Chest"
                this.equals("가슴", true) -> "Chest"

                this.equals("Eo", true) -> "Waist"
                this.equals("허리", true) -> "Waist"

                this.equals("Hông", true) -> "Hip"
                this.equals("엉덩이", true) -> "Hip"

                this.equals("Đùi", true) -> "Thigh"
                this.equals("허벅지", true) -> "Thigh"

                this.equals("Kích cỡ", true) -> "Size"
                this.equals("사이즈", true) -> "Size"

                this.equals("Màu sắc", true) -> "Color"
                this.equals("색상", true) -> "Color"

                this.equals("Trắng", true) -> "White"
                this.equals("화이트", true) -> "White"

                this.equals("Đen", true) -> "Black"
                this.equals("블랙", true) -> "Black"

                else -> this
            }
        }
        else -> {
            return when {
                this.equals("Height", true) -> "Chiều cao"
                this.equals("키", true) -> "Chiều cao"

                this.equals("Weight", true) -> "Cân nặng"
                this.equals("몸무게", true) -> "Cân nặng"

                this.equals("Length", true) -> "Chiều dài áo"
                this.equals("상의 기장", true) -> "Chiều dài áo"

                this.equals("Outseam", true) -> "Chiều dài quần"
                this.equals("하의 기장", true) -> "Chiều dài quần"

                this.equals("Shoulder", true) -> "Vai"
                this.equals("어깨", true) -> "Vai"

                this.equals("Chest", true) -> "Ngực"
                this.equals("가슴", true) -> "Ngực"

                this.equals("Waist", true) -> "Eo"
                this.equals("허리", true) -> "Eo"

                this.equals("Hip", true) -> "Hông"
                this.equals("엉덩이", true) -> "Hông"

                this.equals("Thigh", true) -> "Đùi"
                this.equals("허벅지", true) -> "Đùi"

                this.equals("Size", true) -> "Kích cỡ"
                this.equals("사이즈", true) -> "Kích cỡ"

                this.equals("Color", true) -> "Màu sắc"
                this.equals("색상", true) -> "Màu sắc"

                this.equals("White", true) -> "Trắng"
                this.equals("화이트", true) -> "Trắng"

                this.equals("Black", true) -> "Đen"
                this.equals("블랙", true) -> "Đen"

                else -> this
            }
        }
    }
}

fun getLocalizedGlobal(appLanguage: AppLanguage): String {
    return when (appLanguage) {
        AppLanguage.ENGLISH -> "Global"
        AppLanguage.KOREAN -> "글로벌"
        else -> "Quốc tế"
    }
}

fun String?.onCheckLocalizedGlobal(): Boolean {
    return this.equals("Quốc Tế", true) || this.equals("Global", true) || this.equals("글로벌", true)
}

fun String?.onCheckLocalizedBrand(): Boolean {
    return this.equals("Thương Hiệu", true) || this.equals("Brand", true) || this.equals("브랜드", true)
}

fun String?.onCheckLocalizedSize(): Boolean {
    return this.equals("Kích cỡ", true) || this.equals("Size", true) || this.equals("사이즈", true)
}

fun String?.onCheckLocalizedHeight(): Boolean {
    return this.equals("Chiều cao", true) || this.equals("Height", true) || this.equals("키", true)
}

fun String?.onCheckLocalizedWeight(): Boolean {
    return this.equals("Cân nặng", true) || this.equals("Weight", true) || this.equals("몸무게", true)
}