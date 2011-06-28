package com.parakhcomputer.web.bean;

import java.util.Collection;

public class GhiBean  {


    private Integer ghiBeanId = null;
    private String ghiName;

	public GhiBean() {
		
	}

	

    public Integer getGhiBeanId() {
		return ghiBeanId;
	}



	public void setGhiBeanId(Integer ghiBeanId) {
		this.ghiBeanId = ghiBeanId;
	}



	public String getGhiName() {
		return ghiName;
	}



	public void setGhiName(String ghiName) {
		this.ghiName = ghiName;
	}





	/**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getName() + "-");
        sb.append("  ghiId=" + ghiBeanId);
        sb.append("  name=" + ghiName);

        sb.append("  ghiBeans=[");


        sb.append("]");

        return sb.toString();
    }

    /**
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((ghiBeanId == null) ? 0 : ghiBeanId.hashCode());

        return result;
    }

    /**
     * Indicates whether some other object is equal to this one.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GhiBean other = (GhiBean) obj;

        if (ghiBeanId == null) {
            if (other.ghiBeanId != null) {
                return false;
            }
        } else if (!ghiBeanId.equals(other.ghiBeanId)) {
            return false;
        }

        return true;
    }

}
