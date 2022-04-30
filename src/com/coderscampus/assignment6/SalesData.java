package com.coderscampus.assignment6;

public class SalesData {
	private String modell = null;
	private String monthYear = null;
	private Integer sales = null; 

	public SalesData(String monthYear, String sales) {
		this.monthYear = monthYear;
		this.sales = Integer.parseInt(sales);
	}

	public SalesData(String[] array) {
		this.monthYear = array[0];
		this.sales = Integer.parseInt(array[1]);
	}
    /**
     * @return String return the modell
     */
    public String getModell() {
        return modell;
    }

    /**
     * @param modell the modell to set
     */
    public void setModell(String modell) {
        this.modell = modell;
    }

    /**
     * @return String return the monthYear
     */
    public String getMonthYear() {
        return monthYear;
    }

    /**
     * @param monthYear the monthYear to set
     */
    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }

    /**
     * @return Integer return the sales
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

}
