/**
 * Copyright (c) 2012, Hadyn Richard
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal 
 * in the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN 
 * THE SOFTWARE.
 */

package net.scapeemulator.game.model;

/**
 * Created by Hadyn Richard
 */
public final class Widget {

    /**
     * Calculates the widget hash from a parent and child id.
     * @param parent The parent id.
     * @param child The child id.
     * @return The calculated hash.
     */
    public static int getHash(int parent, int child) {
        return parent << 16 | child;
    }

    /**
     * Gets the widget id of a hash.
     * @param hash The hash to use to get the id from.
     * @return The widget id.
     */
    public static int getWidgetId(int hash) {
        return hash >> 16;
    }

    /**
     * Gets the component id of a hash.
     * @param hash The hash to use to get the component id from.
     * @return The component id.
     */
    public static int getComponentId(int hash) {
        return hash & 0xFFFF;
    }

    /**
     * Prevent construction;
     */
    private Widget() {}
}
