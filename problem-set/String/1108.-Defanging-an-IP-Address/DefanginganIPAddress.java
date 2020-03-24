/**
 * @Title: 1108. Defanging an IP Address
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/25
 */
public class DefanginganIPAddress {

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); ++i) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }

    public String defangIPaddr2(String address) {
        return address.replaceAll("\\.", "[.]");
    }

}