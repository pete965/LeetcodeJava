package Tools;

public class CashFlowCalculator {
    public static void main(String[] args) {
        System.out.printf("%f",cal(1.25f,3,0.10f));
        System.out.println(cal1(15f,3,0.10f));
    }

    /**
     * 理财模型，年化为综合年化，即维持12个月的定存的总量计算整体年化，不存在存款的年化削减问题
     * 3年，每年结余15W，10%年化，最后得到54W
     * @param salary 年工资
     * @param year 年数
     * @param interest 年利率
     * @return 最后总值
     */
    private static float cal1(float salary, int year, float interest) {
        float output = 0.0f;
        for (int i=0;i<year;i++){
            output+=salary;
            output*=(1.0f+interest);
        }
        return output;
    }

    /**
     * 存款模型（综合年利率大概为标记年利率的一半，因为是按月拿工资，第十二个月的工资这一年相当于一天都没存）
     * 计算月结余为salary万的情况下，百分之interest年化的情况下，year年后的现金数（每月计算）
     * 3年时间情况下；5%年化，最终48.44，实际年化2.5%；10%年化，最终52.22，实际年化5.3%
     * @param salary 年结余，单位万，我们看做年底拿到这部分结余
     * @param year 经过的年数
     * @param interest 年存款综合年化利率
     * @return
     */
    private static float cal(float salary, int year, float interest) {
        int month = year * 12;
        interest = interest / 12.0f;
        float fullInterest = 0.0f;
        float output = 0.0f;
        for (int i=0;i<month;i++){
//            当前现金计算当月得利后总价
            float interestAmount = output * interest;
            fullInterest += interestAmount;
            output += interestAmount;
//            年底获得当月工资
            output += salary;
            System.out.printf("month number %d %f; interest is %f\n",i,output,interestAmount);
        }
        System.out.println("Full interest is " + fullInterest);
        System.out.println("Full interest rate is " + fullInterest/(salary*12.0f*year));
        return output;
    }
}
