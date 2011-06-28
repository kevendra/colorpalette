package com.parakhcomputer.web.bean;

import java.util.Collection;

public class AbcBean  {


    private Integer abcBeanId = null;
    private String abcName;
    private Collection<DefBean> defBeans = null;

	public AbcBean() {
		
	}

	

    public Integer getAbcBeanId() {
		return abcBeanId;
	}



	public void setAbcBeanId(Integer abcBeanId) {
		this.abcBeanId = abcBeanId;
	}



	public String getAbcName() {
		return abcName;
	}



	public void setAbcName(String abcName) {
		this.abcName = abcName;
	}



	public Collection<DefBean> getDefBeans() {
		return defBeans;
	}



	public void setDefBeans(Collection<DefBean> defBeans) {
		this.defBeans = defBeans;
	}



	/**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getName() + "-");
        sb.append("  abcId=" + abcBeanId);
        sb.append("  name=" + abcName);

        sb.append("  defBeans=[");

        if (defBeans != null) {
            for (DefBean defBean : defBeans) {
                sb.append(defBean.toString());
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

        result = prime * result + ((abcBeanId == null) ? 0 : abcBeanId.hashCode());

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
        final AbcBean other = (AbcBean) obj;

        if (abcBeanId == null) {
            if (other.abcBeanId != null) {
                return false;
            }
        } else if (!abcBeanId.equals(other.abcBeanId)) {
            return false;
        }

        return true;
    }

}
