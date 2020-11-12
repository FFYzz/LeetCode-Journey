/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/11/13
 */
public class BitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        if (bits[bits.length - 1] != 0) {
            return false;
        }
        return canBeDivided(bits, 0, length - 2);
    }

    public boolean canBeDivided(int[] bits, int start, int end) {
        if (start == end && bits[start] == 0 || start > end) {
            return true;
        }
        if (start == end && bits[start] == 1) {
            return false;
        }
        if (bits[start] == 0) {
            return canBeDivided(bits, start + 1, end);
        } else {
            return canBeDivided(bits, start + 2, end);
        }
    }

}
