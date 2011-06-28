package com.parakhcomputer.web.bean;

import java.util.Collection;

public class DefBean  {


    private Integer defBeanId = null;
    private String defName;
    private Collection<GhiBean> ghiBeans = null;

	public DefBean() {
		
	}

	

    public Integer getDefBeanId() {
		return defBeanId;
	}



	public void setDefBeanId(Integer defBeanId) {
		this.defBeanId = defBeanId;
	}



	public String getDefName() {
		return defName;
	}



	public void setDefName(String defName) {
		this.defName = defName;
	}



	public Collection<GhiBean> getGhiBeans() {
		return ghiBeans;
	}



	public void setGhiBeans(Collection<GhiBean> ghiBeans) {
		this.ghiBeans = ghiBeans;
	}



	/**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getName() + "-");
        sb.append("  defId=" + defBeanId);
        sb.append("  name=" + defName);

        sb.append("  ghiBeans=[");

        if (ghiBeans != null) {
            for (GhiBean ghiBean : ghiBeans) {
                sb.append(ghiBean.toString());
            }
        }

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

        result = prime * result + ((defBeanId == null) ? 0 : defBeanId.hashCode());

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
        final DefBean other = (DefBean) obj;

        if (defBeanId == null) {
            if (other.defBeanId != null) {
                return false;
            }
        } else if (!defBeanId.equals(other.defBeanId)) {
            return false;
        }

        return true;
    }

}
