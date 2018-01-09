/*
 * Copyright (C) 2018. Gowtham Parimelazhagan.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.gm.kotlindemo.util

import android.graphics.Bitmap
import android.graphics.BlurMaskFilter
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.text.Layout.Alignment
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.*

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */

class SpannableStringUtils private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    class Builder  constructor(private var text: CharSequence?) {

        private val defaultValue = 0x12000000

        private var flag: Int = 0
        @ColorInt
        private var foregroundColor: Int = 0
        @ColorInt
        private var backgroundColor: Int = 0
        @ColorInt
        private var quoteColor: Int = 0

        private var isLeadingMargin: Boolean = false
        private var first: Int = 0
        private var rest: Int = 0

        private var isBullet: Boolean = false
        private var gapWidth: Int = 0
        private var bulletColor: Int = 0

        private var proportion: Float = 0.toFloat()
        private var xProportion: Float = 0.toFloat()
        private var isStrikethrough: Boolean = false
        private var isUnderline: Boolean = false
        private var isSuperscript: Boolean = false
        private var isSubscript: Boolean = false
        private var isBold: Boolean = false
        private var isItalic: Boolean = false
        private var isBoldItalic: Boolean = false
        private var fontFamily: String? = null
        private var align: Alignment? = null

        private var imageIsBitmap: Boolean = false
        private var bitmap: Bitmap? = null
        private var imageIsDrawable: Boolean = false
        private var drawable: Drawable? = null
        private var imageIsUri: Boolean = false
        private var uri: Uri? = null
        private var imageIsResourceId: Boolean = false
        @DrawableRes
        private var resourceId: Int = 0

        private var clickSpan: ClickableSpan? = null
        private var url: String? = null

        private var isBlur: Boolean = false
        private var radius: Float = 0.toFloat()
        private var style: BlurMaskFilter.Blur? = null

        private val mBuilder: SpannableStringBuilder


        init {
            flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            foregroundColor = defaultValue
            backgroundColor = defaultValue
            quoteColor = defaultValue
            proportion = -1f
            xProportion = -1f
            mBuilder = SpannableStringBuilder()
        }

        /**
         * Set the Flag
         *
         * @param flag <ul>
         *             <li>{@link Spanned#SPAN_INCLUSIVE_EXCLUSIVE}</li>
         *             <li>{@link Spanned#SPAN_INCLUSIVE_INCLUSIVE}</li>
         *             <li>{@link Spanned#SPAN_EXCLUSIVE_EXCLUSIVE}</li>
         *             <li>{@link Spanned#SPAN_EXCLUSIVE_INCLUSIVE}</li>
         *             </ul>
         * @return {@link Builder}
         */
        fun setFlag(flag: Int): Builder {
            this.flag = flag
            return this
        }

        /**
         * Set the foreground color
         *
         * @param color Foreground color
         * @return {@link Builder}
         */
        fun setForegroundColor(@ColorInt color: Int): Builder {
            this.foregroundColor = color
            return this
        }

        /**
         * Set background color
         *
         * @param color Background color
         * @return {@link Builder}
         */
        fun setBackgroundColor(@ColorInt color: Int): Builder {
            this.backgroundColor = color
            return this
        }

        /**
         * Sets the color of the reference line
         *
         * @param color Quote the color of the line
         * @return {@link Builder}
         */
        fun setQuoteColor(@ColorInt color: Int): Builder {
            this.quoteColor = color
            return this
        }

        /**
         * Set indent
         *
         * @param first First line indent
         * @param rest  The remaining lines are indented
         * @return {@link Builder}
         */
        fun setLeadingMargin(first: Int, rest: Int): Builder {
            this.first = first
            this.rest = rest
            isLeadingMargin = true
            return this
        }

        /**
         * Set the list of tags
         *
         * @param gapWidth List the distance between the mark and the text
         * @param color    The color of the list tag
         * @return {@link Builder}
         */
        fun setBullet(gapWidth: Int, color: Int): Builder {
            this.gapWidth = gapWidth
            bulletColor = color
            isBullet = true
            return this
        }

        /**
         * Set the font scale
         *
         * @param proportion proportion
         * @return {@link Builder}
         */
        fun setProportion(proportion: Float): Builder {
            this.proportion = proportion
            return this
        }

        /**
         * Set the font aspect ratio
         *
         * @param proportion proportion
         * @return {@link Builder}
         */
        fun setXProportion(proportion: Float): Builder {
            this.xProportion = proportion
            return this
        }

        /**
         * Set the strikethrough
         *
         * @return {@link Builder}
         */
        fun setStrikethrough(): Builder {
            this.isStrikethrough = true
            return this
        }

        /**
         * Set underline
         *
         * @return [Builder]
         */
        fun setUnderline(): Builder {
            this.isUnderline = true
            return this
        }

        /**
         * Set the superscript
         *
         * @return [Builder]
         */
        fun setSuperscript(): Builder {
            this.isSuperscript = true
            return this
        }

        /**
         * Set the subscript
         *
         * @return [Builder]
         */
        fun setSubscript(): Builder {
            this.isSubscript = true
            return this
        }

        /**
         * Set bold
         *
         * @return [Builder]
         */
        fun setBold(): Builder {
            isBold = true
            return this
        }

        /**
         * Set italic
         *
         * @return [Builder]
         */
        fun setItalic(): Builder {
            isItalic = true
            return this
        }

        /**
         * Set BoldItalic
         *
         * @return [Builder]
         */
        fun setBoldItalic(): Builder {
            isBoldItalic = true
            return this
        }

        /**
         * Set the font
         *
         * @param fontFamily Font
         *
         *  * monospace
         *  * serif
         *  * sans-serif
         *
         * @return [Builder]
         */
        fun setFontFamily(fontFamily: String?): Builder {
            this.fontFamily = fontFamily
            return this
        }

        /**
         * Set alignment
         *
         * @param align On its way
         *
         *  * [Alignment.ALIGN_NORMAL]normal
         *  * [Alignment.ALIGN_OPPOSITE]OPPOSITE
         *  * [Alignment.ALIGN_CENTER]Centered
         *
         * @return [Builder]
         */
        fun setAlign(align: Alignment?): Builder {
            this.align = align
            return this
        }

        /**
         * Set the picture
         *
         * @param bitmap Image bitmap
         * @return [Builder]
         */
        fun setBitmap(bitmap: Bitmap): Builder {
            this.bitmap = bitmap
            imageIsBitmap = true
            return this
        }

        /**
         * Set the picture
         *
         * @param drawable Picture resources
         * @return [Builder]
         */
        fun setDrawable(drawable: Drawable): Builder {
            this.drawable = drawable
            imageIsDrawable = true
            return this
        }

        /**
         * Set the picture
         *
         * @param uri image uri
         * @return [Builder]
         */
        fun setUri(uri: Uri): Builder {
            this.uri = uri
            imageIsUri = true
            return this
        }

        /**
         * Set the picture
         *
         * @param resourceId Image resource id
         * @return [Builder]
         */
        fun setResourceId(@DrawableRes resourceId: Int): Builder {
            this.resourceId = resourceId
            imageIsResourceId = true
            return this
        }

        /**
         * Set the click event
         *
         * Need to be added view.setMovementMethod(LinkMovementMethod.getInstance())
         *
         * @param clickSpan Click event
         * @return [Builder]
         */
        fun setClickSpan(clickSpan: ClickableSpan): Builder {
            this.clickSpan = clickSpan
            return this
        }

        /**
         * Set the hyperlink
         *
         * Need to be added view.setMovementMethod(LinkMovementMethod.getInstance())
         *
         * @param url Hyperlink
         * @return [Builder]
         */
        fun setUrl(url: String): Builder {
            this.url = url
            return this
        }

        /**
         * Set blur
         *
         * Surviving bugs, other places where the same font exists, the same font appears in the previous words then it will not blur, appear in the words that will be blurred
         *
         * Recommend or use all the fonts are blurred
         *
         * @param radius Blurring radius (greater than 0)）
         * @param style  Fuzzy style
         *  * [Blur.NORMAL]
         *  * [Blur.SOLID]
         *  * [Blur.OUTER]
         *  * [Blur.INNER]
         *
         * @return [Builder]
         */
        fun setBlur(radius: Float, style: BlurMaskFilter.Blur): Builder {
            this.radius = radius
            this.style = style
            this.isBlur = true
            return this
        }

        /**
         * Append style string
         *
         * @param text Style string text
         * @return [Builder]
         */
        fun append(text: CharSequence): Builder {
            setSpan()
            this.text = text
            return this
        }

        /**
         * Create a style string
         *
         * @return Style string
         */
        fun create(): SpannableStringBuilder {
            setSpan()
            return mBuilder
        }

        /**
         * Set the style
         */
        private fun setSpan() {
            val start = mBuilder.length
            mBuilder.append(this.text)
            val end = mBuilder.length
            if (foregroundColor != defaultValue) {
                mBuilder.setSpan(ForegroundColorSpan(foregroundColor), start, end, flag)
                foregroundColor = defaultValue
            }
            if (backgroundColor != defaultValue) {
                mBuilder.setSpan(BackgroundColorSpan(backgroundColor), start, end, flag)
                backgroundColor = defaultValue
            }
            if (isLeadingMargin) {
                mBuilder.setSpan(LeadingMarginSpan.Standard(first, rest), start, end, flag)
                isLeadingMargin = false
            }
            if (quoteColor != defaultValue) {
                mBuilder.setSpan(QuoteSpan(quoteColor), start, end, 0)
                quoteColor = defaultValue
            }
            if (isBullet) {
                mBuilder.setSpan(BulletSpan(gapWidth, bulletColor), start, end, 0)
                isBullet = false
            }
            if (proportion != -1f) {
                mBuilder.setSpan(RelativeSizeSpan(proportion), start, end, flag)
                proportion = -1f
            }
            if (xProportion != -1f) {
                mBuilder.setSpan(ScaleXSpan(xProportion), start, end, flag)
                xProportion = -1f
            }
            if (isStrikethrough) {
                mBuilder.setSpan(StrikethroughSpan(), start, end, flag)
                isStrikethrough = false
            }
            if (isUnderline) {
                mBuilder.setSpan(UnderlineSpan(), start, end, flag)
                isUnderline = false
            }
            if (isSuperscript) {
                mBuilder.setSpan(SuperscriptSpan(), start, end, flag)
                isSuperscript = false
            }
            if (isSubscript) {
                mBuilder.setSpan(SubscriptSpan(), start, end, flag)
                isSubscript = false
            }
            if (isBold) {
                mBuilder.setSpan(StyleSpan(Typeface.BOLD), start, end, flag)
                isBold = false
            }
            if (isItalic) {
                mBuilder.setSpan(StyleSpan(Typeface.ITALIC), start, end, flag)
                isItalic = false
            }
            if (isBoldItalic) {
                mBuilder.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, end, flag)
                isBoldItalic = false
            }
            if (fontFamily != null) {
                mBuilder.setSpan(TypefaceSpan(fontFamily), start, end, flag)
                fontFamily = null
            }
            if (align != null) {
                mBuilder.setSpan(AlignmentSpan.Standard(align), start, end, flag)
                align = null
            }
            if (imageIsBitmap || imageIsDrawable || imageIsUri || imageIsResourceId) {
                if (imageIsBitmap) {
                    mBuilder.setSpan(ImageSpan(Utils.getContext(), bitmap), start, end, flag)
                    bitmap = null
                    imageIsBitmap = false
                } else if (imageIsDrawable) {
                    mBuilder.setSpan(ImageSpan(drawable), start, end, flag)
                    drawable = null
                    imageIsDrawable = false
                } else if (imageIsUri) {
                    mBuilder.setSpan(ImageSpan(Utils.getContext(), uri), start, end, flag)
                    uri = null
                    imageIsUri = false
                } else {
                    mBuilder.setSpan(ImageSpan(Utils.getContext(), resourceId), start, end, flag)
                    resourceId = 0
                    imageIsResourceId = false
                }
            }
            if (clickSpan != null) {
                mBuilder.setSpan(clickSpan, start, end, flag)
                clickSpan = null
            }
            if (url != null) {
                mBuilder.setSpan(URLSpan(url), start, end, flag)
                url = null
            }
            if (isBlur) {
                mBuilder.setSpan(MaskFilterSpan(BlurMaskFilter(radius, style)), start, end, flag)
                isBlur = false
            }
            flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        }
    }
}
