package cn.sk.collection;

/**
 * 实体类 包含一个静态内部类 Builder
 */
public class CompanyClient {
   public final String companyName;
   public final double companyRegfunds;

	//构造方法
    public CompanyClient() {
        this(new Builder());
    }
	
	//构造方法
	public CompanyClient(Builder builder){
        this.companyName = builder.companyName;
        this.companyRegfunds = builder.companyRegfunds;
    }
    public String getCompanyName() {
        return companyName;
    }

    public double getCompanyRegfunds() {
        return companyRegfunds;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }
 
    @Override
    public String toString() {
        return "CompanyClient{" +
                "companyName='" + companyName + '\'' +
                ", companyRegfunds=" + companyRegfunds +"千万"+
                '}';
    }
	/**
	*静态内部类 Builder
	*/
    public static class Builder{
       public String companyName;
       public  double companyRegfunds;
	   //构造方法
       public Builder() {
           companyName = companyName;
           companyRegfunds = companyRegfunds;
       }
	   //构造方法
       Builder(CompanyClient companyClient){
           this.companyName = companyClient.companyName;
           this.companyRegfunds = companyClient.companyRegfunds;
       }
       public Builder setCompanyName(String name) {
           companyName = name;
           return this;
       }
       public Builder setCompanyRegfunds(double regfunds) {
           companyRegfunds = regfunds;
           return this;
       }
		//构建一个实体
        public CompanyClient build() {
            return new CompanyClient(this);
        }
   }
    public static void main(String[] args) {

        CompanyClient client = new CompanyClient.Builder()
                .setCompanyName("百度")
                .setCompanyRegfunds(5)
                .build();
        System.out.println("构造出一个公司：" + client.toString());

        System.out.println("---------------------分隔符");

        CompanyClient.Builder builder = new CompanyClient.Builder();
        builder.setCompanyName("华为");
        builder.setCompanyRegfunds(20);
        CompanyClient client1 = builder.build();
        System.out.println("构造出另一个公司：" + client1.toString());
    }

}