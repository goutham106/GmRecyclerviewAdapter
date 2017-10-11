/*
 * Copyright (C) 2017. Gowtham Parimelazhagan.
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

package com.gm.baseadapter.demo.util;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;

import static android.graphics.BlurMaskFilter.Blur;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/20/17.
 */
public class SpannableStringUtils {

    private SpannableStringUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Get builder
     *
     * @param text Style string text
     * @return {@link Builder}
     */
    public static Builder getBuilder(@NonNull CharSequence text) {
        return new Builder(text);
    }

    public static class Builder {

        private int defaultValue = 0x12000000;
        private CharSequence text;

        private int flag;
        @ColorInt
        private int foregroundColor;
        @ColorInt
        private int backgroundColor;
        @ColorInt
        private int quoteColor;

        private boolean isLeadingMargin;
        private int first;
        private int rest;

        private boolean isBullet;
        private int gapWidth;
        private int bulletColor;

        private float proportion;
        private float xProportion;
        private boolean isStrikethrough;
        private boolean isUnderline;
        private boolean isSuperscript;
        private boolean isSubscript;
        private boolean isBold;
        private boolean isItalic;
        private boolean isBoldItalic;
        private String fontFamily;
        private Alignment align;

        private boolean imageIsBitmap;
        private Bitmap bitmap;
        private boolean imageIsDrawable;
        private Drawable drawable;
        private boolean imageIsUri;
        private Uri uri;
        private boolean imageIsResourceId;
        @DrawableRes
        private int resourceId;

        private ClickableSpan clickSpan;
        private String url;

        private boolean isBlur;
        private float radius;
        private Blur style;

        private SpannableStringBuilder mBuilder;


        private Builder(@NonNull CharSequence text) {
            this.text = text;
            flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
            foregroundColor = defaultValue;
            backgroundColor = defaultValue;
            quoteColor = defaultValue;
            proportion = -1;
            xProportion = -1;
            mBuilder = new SpannableStringBuilder();
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
        public Builder setFlag(int flag) {
            this.flag = flag;
            return this;
        }

        /**
         * Set the foreground color
         *
         * @param color Foreground color
         * @return {@link Builder}
         */
        public Builder setForegroundColor(@ColorInt int color) {
            this.foregroundColor = color;
            return this;
        }

        /**
         * Set background color
         *
         * @param color Background color
         * @return {@link Builder}
         */
        public Builder setBackgroundColor(@ColorInt int color) {
            this.backgroundColor = color;
            return this;
        }

        /**
         * Sets the color of the reference line
         *
         * @param color Quote the color of the line
         * @return {@link Builder}
         */
        public Builder setQuoteColor(@ColorInt int color) {
            this.quoteColor = color;
            return this;
        }

        /**
         * Set indent
         *
         * @param first First line indent
         * @param rest  The remaining lines are indented
         * @return {@link Builder}
         */
        public Builder setLeadingMargin(int first, int rest) {
            this.first = first;
            this.rest = rest;
            isLeadingMargin = true;
            return this;
        }

        /**
         * Set the list of tags
         *
         * @param gapWidth List the distance between the mark and the text
         * @param color    The color of the list tag
         * @return {@link Builder}
         */
        public Builder setBullet(int gapWidth, int color) {
            this.gapWidth = gapWidth;
            bulletColor = color;
            isBullet = true;
            return this;
        }

        /**
         * Set the font scale
         *
         * @param proportion proportion
         * @return {@link Builder}
         */
        public Builder setProportion(float proportion) {
            this.proportion = proportion;
            return this;
        }

        /**
         * Set the font aspect ratio
         *
         * @param proportion proportion
         * @return {@link Builder}
         */
        public Builder setXProportion(float proportion) {
            this.xProportion = proportion;
            return this;
        }

        /**
         * Set the strikethrough
         *
         * @return {@link Builder}
         */
        public Builder setStrikethrough() {
            this.isStrikethrough = true;
            return this;
        }

        /**
         * Set underline
         *
         * @return {@link Builder}
         */
        public Builder setUnderline() {
            this.isUnderline = true;
            return this;
        }

        /**
         * Set the superscript
         *
         * @return {@link Builder}
         */
        public Builder setSuperscript() {
            this.isSuperscript = true;
            return this;
        }

        /**
         * Set the subscript
         *
         * @return {@link Builder}
         */
        public Builder setSubscript() {
            this.isSubscript = true;
            return this;
        }

        /**
         * Set bold
         *
         * @return {@link Builder}
         */
        public Builder setBold() {
            isBold = true;
            return this;
        }

        /**
         * Set italic
         *
         * @return {@link Builder}
         */
        public Builder setItalic() {
            isItalic = true;
            return this;
        }

        /**
         * Set BoldItalic
         *
         * @return {@link Builder}
         */
        public Builder setBoldItalic() {
            isBoldItalic = true;
            return this;
        }

        /**
         * Set the font
         *
         * @param fontFamily Font
         *                   <ul>
         *                   <li>monospace</li>
         *                   <li>serif</li>
         *                   <li>sans-serif</li>
         *                   </ul>
         * @return {@link Builder}
         */
        public Builder setFontFamily(@Nullable String fontFamily) {
            this.fontFamily = fontFamily;
            return this;
        }

        /**
         * Set alignment
         *
         * @param align On its way
         *              <ul>
         *              <li>{@link Alignment#ALIGN_NORMAL}normal</li>
         *              <li>{@link Alignment#ALIGN_OPPOSITE}OPPOSITE</li>
         *              <li>{@link Alignment#ALIGN_CENTER}Centered</li>
         *              </ul>
         * @return {@link Builder}
         */
        public Builder setAlign(@Nullable Alignment align) {
            this.align = align;
            return this;
        }

        /**
         * Set the picture
         *
         * @param bitmap Image bitmap
         * @return {@link Builder}
         */
        public Builder setBitmap(@NonNull Bitmap bitmap) {
            this.bitmap = bitmap;
            imageIsBitmap = true;
            return this;
        }

        /**
         * Set the picture
         *
         * @param drawable Picture resources
         * @return {@link Builder}
         */
        public Builder setDrawable(@NonNull Drawable drawable) {
            this.drawable = drawable;
            imageIsDrawable = true;
            return this;
        }

        /**
         * Set the picture
         *
         * @param uri image uri
         * @return {@link Builder}
         */
        public Builder setUri(@NonNull Uri uri) {
            this.uri = uri;
            imageIsUri = true;
            return this;
        }

        /**
         * Set the picture
         *
         * @param resourceId Image resource id
         * @return {@link Builder}
         */
        public Builder setResourceId(@DrawableRes int resourceId) {
            this.resourceId = resourceId;
            imageIsResourceId = true;
            return this;
        }

        /**
         * Set the click event
         * <p>Need to be added view.setMovementMethod(LinkMovementMethod.getInstance())</p>
         *
         * @param clickSpan Click event
         * @return {@link Builder}
         */
        public Builder setClickSpan(@NonNull ClickableSpan clickSpan) {
            this.clickSpan = clickSpan;
            return this;
        }

        /**
         * Set the hyperlink
         * <p>Need to be added view.setMovementMethod(LinkMovementMethod.getInstance())</p>
         *
         * @param url Hyperlink
         * @return {@link Builder}
         */
        public Builder setUrl(@NonNull String url) {
            this.url = url;
            return this;
        }

        /**
         * Set blur
         * <p>Surviving bugs, other places where the same font exists, the same font appears in the previous words then it will not blur, appear in the words that will be blurred</p>
         * <p>Recommend or use all the fonts are blurred</p>
         *
         * @param radius Blurring radius (greater than 0)）
         * @param style  Fuzzy style<ul>
         *               <li>{@link Blur#NORMAL}</li>
         *               <li>{@link Blur#SOLID}</li>
         *               <li>{@link Blur#OUTER}</li>
         *               <li>{@link Blur#INNER}</li>
         *               </ul>
         * @return {@link Builder}
         */
        public Builder setBlur(float radius, Blur style) {
            this.radius = radius;
            this.style = style;
            this.isBlur = true;
            return this;
        }

        /**
         * Append style string
         *
         * @param text Style string text
         * @return {@link Builder}
         */
        public Builder append(@NonNull CharSequence text) {
            setSpan();
            this.text = text;
            return this;
        }

        /**
         * Create a style string
         *
         * @return Style string
         */
        public SpannableStringBuilder create() {
            setSpan();
            return mBuilder;
        }

        /**
         * Set the style
         */
        private void setSpan() {
            int start = mBuilder.length();
            mBuilder.append(this.text);
            int end = mBuilder.length();
            if (foregroundColor != defaultValue) {
                mBuilder.setSpan(new ForegroundColorSpan(foregroundColor), start, end, flag);
                foregroundColor = defaultValue;
            }
            if (backgroundColor != defaultValue) {
                mBuilder.setSpan(new BackgroundColorSpan(backgroundColor), start, end, flag);
                backgroundColor = defaultValue;
            }
            if (isLeadingMargin) {
                mBuilder.setSpan(new LeadingMarginSpan.Standard(first, rest), start, end, flag);
                isLeadingMargin = false;
            }
            if (quoteColor != defaultValue) {
                mBuilder.setSpan(new QuoteSpan(quoteColor), start, end, 0);
                quoteColor = defaultValue;
            }
            if (isBullet) {
                mBuilder.setSpan(new BulletSpan(gapWidth, bulletColor), start, end, 0);
                isBullet = false;
            }
            if (proportion != -1) {
                mBuilder.setSpan(new RelativeSizeSpan(proportion), start, end, flag);
                proportion = -1;
            }
            if (xProportion != -1) {
                mBuilder.setSpan(new ScaleXSpan(xProportion), start, end, flag);
                xProportion = -1;
            }
            if (isStrikethrough) {
                mBuilder.setSpan(new StrikethroughSpan(), start, end, flag);
                isStrikethrough = false;
            }
            if (isUnderline) {
                mBuilder.setSpan(new UnderlineSpan(), start, end, flag);
                isUnderline = false;
            }
            if (isSuperscript) {
                mBuilder.setSpan(new SuperscriptSpan(), start, end, flag);
                isSuperscript = false;
            }
            if (isSubscript) {
                mBuilder.setSpan(new SubscriptSpan(), start, end, flag);
                isSubscript = false;
            }
            if (isBold) {
                mBuilder.setSpan(new StyleSpan(Typeface.BOLD), start, end, flag);
                isBold = false;
            }
            if (isItalic) {
                mBuilder.setSpan(new StyleSpan(Typeface.ITALIC), start, end, flag);
                isItalic = false;
            }
            if (isBoldItalic) {
                mBuilder.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), start, end, flag);
                isBoldItalic = false;
            }
            if (fontFamily != null) {
                mBuilder.setSpan(new TypefaceSpan(fontFamily), start, end, flag);
                fontFamily = null;
            }
            if (align != null) {
                mBuilder.setSpan(new AlignmentSpan.Standard(align), start, end, flag);
                align = null;
            }
            if (imageIsBitmap || imageIsDrawable || imageIsUri || imageIsResourceId) {
                if (imageIsBitmap) {
                    mBuilder.setSpan(new ImageSpan(Utils.getContext(), bitmap), start, end, flag);
                    bitmap = null;
                    imageIsBitmap = false;
                } else if (imageIsDrawable) {
                    mBuilder.setSpan(new ImageSpan(drawable), start, end, flag);
                    drawable = null;
                    imageIsDrawable = false;
                } else if (imageIsUri) {
                    mBuilder.setSpan(new ImageSpan(Utils.getContext(), uri), start, end, flag);
                    uri = null;
                    imageIsUri = false;
                } else {
                    mBuilder.setSpan(new ImageSpan(Utils.getContext(), resourceId), start, end, flag);
                    resourceId = 0;
                    imageIsResourceId = false;
                }
            }
            if (clickSpan != null) {
                mBuilder.setSpan(clickSpan, start, end, flag);
                clickSpan = null;
            }
            if (url != null) {
                mBuilder.setSpan(new URLSpan(url), start, end, flag);
                url = null;
            }
            if (isBlur) {
                mBuilder.setSpan(new MaskFilterSpan(new BlurMaskFilter(radius, style)), start, end, flag);
                isBlur = false;
            }
            flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
        }
    }
}
