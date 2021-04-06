/*
 * Copyright 2021 Kato Shinya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.thinkit.bot.instagram.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.thinkit.bot.instagram.catalog.ElementAttribute;
import org.thinkit.bot.instagram.catalog.ElementCssSelector;
import org.thinkit.bot.instagram.catalog.ElementTag;
import org.thinkit.bot.instagram.catalog.ElementXPath;
import org.thinkit.bot.instagram.catalog.InstagramUrl;
import org.thinkit.bot.instagram.tag.HashTag;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "from")
public final class AutoLikeCommand extends AbstractBotCommand {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 6084564883236221860L;

    /**
     * The hash tag
     */
    private HashTag hashTag;

    @Override
    public boolean execute(@NonNull final WebDriver webDriver) {

        super.wait(webDriver, 50000);

        webDriver.get(String.format(InstagramUrl.TAGS.getTag(), hashTag.getTag()));
        super.waitUntilElementLocated(webDriver, By.xpath(ElementXPath.TAGS_FIRST_ELEMENT.getTag()));
        super.click(webDriver, By.xpath(ElementXPath.TAGS_FIRST_ELEMENT.getTag()));

        int countLikes = 0;
        while (countLikes < 11) {

            if (countLikes != 0 && countLikes % 10 == 0) {
                super.wait(webDriver, 50000);
            }

            final WebElement likeButton = webDriver.findElement(By.xpath(ElementXPath.LIKE_BUTTON.getTag()));
            final String likeState = likeButton.findElement(By.tagName(ElementTag.SVG.getTag()))
                    .getAttribute(ElementAttribute.ARIA_LABEL.getTag());

            if (likeState.contains("取り消す")) {
                this.clickNextArrorw(webDriver);
                continue;
            }

            likeButton.click();
            this.clickNextArrorw(webDriver);
            countLikes++;
        }

        return true;
    }

    private void clickNextArrorw(@NonNull final WebDriver webDriver) {
        super.click(webDriver, By.cssSelector(ElementCssSelector.NEXT_ARROW.getTag()));
    }
}
