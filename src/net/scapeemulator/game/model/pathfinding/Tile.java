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

package net.scapeemulator.game.model.pathfinding;

/**
 * Created by Hadyn Richard
 */
public final class Tile {

    /**
     * The flags for each of the traversals.
     */
    public static final int /* Each of the flags for walls */
                            WALL_NORTH       = 0x1,  WALL_SOUTH      = 0x2,
                            WALL_EAST        = 0x4,  WALL_WEST       = 0x8,
                            WALL_NORTH_EAST  = 0x10, WALL_NORTH_WEST = 0x20,
                            WALL_SOUTH_EAST  = 0x40, WALL_SOUTH_WEST = 0x80,

                            /* Each of the occupant flags for both impenetrable and normal */
                            OCCUPANT = 0x8000, IMPENETRABLE_OCCUPANT = 0x10000,

                            /* Each of the impenetrable wall flags, meaning projectiles cannot fly over these */
                            IMPENETRABLE_WALL_NORTH       = 0x100,  IMPENETRABLE_WALL_SOUTH      = 0x200,
                            IMPENETRABLE_WALL_EAST        = 0x400,  IMPENETRABLE_WALL_WEST       = 0x800,
                            IMPENETRABLE_WALL_NORTH_EAST  = 0x800,  IMPENETRABLE_WALL_NORTH_WEST = 0x1000,
                            IMPENETRABLE_WALL_SOUTH_EAST  = 0x2000, IMPENETRABLE_WALL_SOUTH_WEST = 0x4000,

                            /* The other flags */
                            BLOCKED = 0x20000, BRIDGE = 0x40000, NONE = 0x0;

    /**
     * The flags for the tile.
     */
    private int flags;

    /**
     * Constructs a new {@link Tile};
     */
    public Tile() {
        this(NONE);
    }

    /**
     * Constructs a new {@link Tile};
     */
    public Tile(int flags) {
        this.flags = flags;
    }

    /**
     * Sets a flag for the tile.
     */
    public void set(int flag) {
        flags |= flag;
    }

    /**
     * Unsets a flag for the tile.
     */
    public void unset(int flag) {
        flags &= 0xffff - flag;
    }

    /**
     * Gets if a flag is active.
     * @param flag The flag to check for if it is active.
     * @return If the flag is active.
     */
    public boolean isActive(int flag) {
        return (flags & flag) != 0;
    }

    /**
     * Gets if a flag is inactive.
     * @param flag The flag to check for if it is inactive.
     * @return If the flag is inactive.
     */
    public boolean isInactive(int flag) {
        return (flags & flag) == 0;
    }

    /**
     * Gets the flags for the tile.
     */
    public int flags() {
        return flags;
    }
}
