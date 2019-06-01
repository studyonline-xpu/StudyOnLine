package com.study_online.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CatalogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CatalogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCatalogIdIsNull() {
            addCriterion("catalog_id is null");
            return (Criteria) this;
        }

        public Criteria andCatalogIdIsNotNull() {
            addCriterion("catalog_id is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogIdEqualTo(String value) {
            addCriterion("catalog_id =", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotEqualTo(String value) {
            addCriterion("catalog_id <>", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdGreaterThan(String value) {
            addCriterion("catalog_id >", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdGreaterThanOrEqualTo(String value) {
            addCriterion("catalog_id >=", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLessThan(String value) {
            addCriterion("catalog_id <", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLessThanOrEqualTo(String value) {
            addCriterion("catalog_id <=", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLike(String value) {
            addCriterion("catalog_id like", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotLike(String value) {
            addCriterion("catalog_id not like", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdIn(List<String> values) {
            addCriterion("catalog_id in", values, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotIn(List<String> values) {
            addCriterion("catalog_id not in", values, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdBetween(String value1, String value2) {
            addCriterion("catalog_id between", value1, value2, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotBetween(String value1, String value2) {
            addCriterion("catalog_id not between", value1, value2, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIsNull() {
            addCriterion("catalog_name is null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIsNotNull() {
            addCriterion("catalog_name is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameEqualTo(String value) {
            addCriterion("catalog_name =", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotEqualTo(String value) {
            addCriterion("catalog_name <>", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThan(String value) {
            addCriterion("catalog_name >", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThanOrEqualTo(String value) {
            addCriterion("catalog_name >=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThan(String value) {
            addCriterion("catalog_name <", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThanOrEqualTo(String value) {
            addCriterion("catalog_name <=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLike(String value) {
            addCriterion("catalog_name like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotLike(String value) {
            addCriterion("catalog_name not like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIn(List<String> values) {
            addCriterion("catalog_name in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotIn(List<String> values) {
            addCriterion("catalog_name not in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameBetween(String value1, String value2) {
            addCriterion("catalog_name between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotBetween(String value1, String value2) {
            addCriterion("catalog_name not between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andFatherIdIsNull() {
            addCriterion("father_id is null");
            return (Criteria) this;
        }

        public Criteria andFatherIdIsNotNull() {
            addCriterion("father_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatherIdEqualTo(String value) {
            addCriterion("father_id =", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotEqualTo(String value) {
            addCriterion("father_id <>", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdGreaterThan(String value) {
            addCriterion("father_id >", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdGreaterThanOrEqualTo(String value) {
            addCriterion("father_id >=", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLessThan(String value) {
            addCriterion("father_id <", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLessThanOrEqualTo(String value) {
            addCriterion("father_id <=", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLike(String value) {
            addCriterion("father_id like", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotLike(String value) {
            addCriterion("father_id not like", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdIn(List<String> values) {
            addCriterion("father_id in", values, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotIn(List<String> values) {
            addCriterion("father_id not in", values, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdBetween(String value1, String value2) {
            addCriterion("father_id between", value1, value2, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotBetween(String value1, String value2) {
            addCriterion("father_id not between", value1, value2, "fatherId");
            return (Criteria) this;
        }

        public Criteria andIsFatherIsNull() {
            addCriterion("is_father is null");
            return (Criteria) this;
        }

        public Criteria andIsFatherIsNotNull() {
            addCriterion("is_father is not null");
            return (Criteria) this;
        }

        public Criteria andIsFatherEqualTo(Boolean value) {
            addCriterion("is_father =", value, "isFather");
            return (Criteria) this;
        }

        public Criteria andIsFatherNotEqualTo(Boolean value) {
            addCriterion("is_father <>", value, "isFather");
            return (Criteria) this;
        }

        public Criteria andIsFatherGreaterThan(Boolean value) {
            addCriterion("is_father >", value, "isFather");
            return (Criteria) this;
        }

        public Criteria andIsFatherGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_father >=", value, "isFather");
            return (Criteria) this;
        }

        public Criteria andIsFatherLessThan(Boolean value) {
            addCriterion("is_father <", value, "isFather");
            return (Criteria) this;
        }

        public Criteria andIsFatherLessThanOrEqualTo(Boolean value) {
            addCriterion("is_father <=", value, "isFather");
            return (Criteria) this;
        }

        public Criteria andIsFatherIn(List<Boolean> values) {
            addCriterion("is_father in", values, "isFather");
            return (Criteria) this;
        }

        public Criteria andIsFatherNotIn(List<Boolean> values) {
            addCriterion("is_father not in", values, "isFather");
            return (Criteria) this;
        }

        public Criteria andIsFatherBetween(Boolean value1, Boolean value2) {
            addCriterion("is_father between", value1, value2, "isFather");
            return (Criteria) this;
        }

        public Criteria andIsFatherNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_father not between", value1, value2, "isFather");
            return (Criteria) this;
        }

        public Criteria andFormarIdIsNull() {
            addCriterion("formar_id is null");
            return (Criteria) this;
        }

        public Criteria andFormarIdIsNotNull() {
            addCriterion("formar_id is not null");
            return (Criteria) this;
        }

        public Criteria andFormarIdEqualTo(String value) {
            addCriterion("formar_id =", value, "formarId");
            return (Criteria) this;
        }

        public Criteria andFormarIdNotEqualTo(String value) {
            addCriterion("formar_id <>", value, "formarId");
            return (Criteria) this;
        }

        public Criteria andFormarIdGreaterThan(String value) {
            addCriterion("formar_id >", value, "formarId");
            return (Criteria) this;
        }

        public Criteria andFormarIdGreaterThanOrEqualTo(String value) {
            addCriterion("formar_id >=", value, "formarId");
            return (Criteria) this;
        }

        public Criteria andFormarIdLessThan(String value) {
            addCriterion("formar_id <", value, "formarId");
            return (Criteria) this;
        }

        public Criteria andFormarIdLessThanOrEqualTo(String value) {
            addCriterion("formar_id <=", value, "formarId");
            return (Criteria) this;
        }

        public Criteria andFormarIdLike(String value) {
            addCriterion("formar_id like", value, "formarId");
            return (Criteria) this;
        }

        public Criteria andFormarIdNotLike(String value) {
            addCriterion("formar_id not like", value, "formarId");
            return (Criteria) this;
        }

        public Criteria andFormarIdIn(List<String> values) {
            addCriterion("formar_id in", values, "formarId");
            return (Criteria) this;
        }

        public Criteria andFormarIdNotIn(List<String> values) {
            addCriterion("formar_id not in", values, "formarId");
            return (Criteria) this;
        }

        public Criteria andFormarIdBetween(String value1, String value2) {
            addCriterion("formar_id between", value1, value2, "formarId");
            return (Criteria) this;
        }

        public Criteria andFormarIdNotBetween(String value1, String value2) {
            addCriterion("formar_id not between", value1, value2, "formarId");
            return (Criteria) this;
        }

        public Criteria andLatterIdIsNull() {
            addCriterion("latter_id is null");
            return (Criteria) this;
        }

        public Criteria andLatterIdIsNotNull() {
            addCriterion("latter_id is not null");
            return (Criteria) this;
        }

        public Criteria andLatterIdEqualTo(String value) {
            addCriterion("latter_id =", value, "latterId");
            return (Criteria) this;
        }

        public Criteria andLatterIdNotEqualTo(String value) {
            addCriterion("latter_id <>", value, "latterId");
            return (Criteria) this;
        }

        public Criteria andLatterIdGreaterThan(String value) {
            addCriterion("latter_id >", value, "latterId");
            return (Criteria) this;
        }

        public Criteria andLatterIdGreaterThanOrEqualTo(String value) {
            addCriterion("latter_id >=", value, "latterId");
            return (Criteria) this;
        }

        public Criteria andLatterIdLessThan(String value) {
            addCriterion("latter_id <", value, "latterId");
            return (Criteria) this;
        }

        public Criteria andLatterIdLessThanOrEqualTo(String value) {
            addCriterion("latter_id <=", value, "latterId");
            return (Criteria) this;
        }

        public Criteria andLatterIdLike(String value) {
            addCriterion("latter_id like", value, "latterId");
            return (Criteria) this;
        }

        public Criteria andLatterIdNotLike(String value) {
            addCriterion("latter_id not like", value, "latterId");
            return (Criteria) this;
        }

        public Criteria andLatterIdIn(List<String> values) {
            addCriterion("latter_id in", values, "latterId");
            return (Criteria) this;
        }

        public Criteria andLatterIdNotIn(List<String> values) {
            addCriterion("latter_id not in", values, "latterId");
            return (Criteria) this;
        }

        public Criteria andLatterIdBetween(String value1, String value2) {
            addCriterion("latter_id between", value1, value2, "latterId");
            return (Criteria) this;
        }

        public Criteria andLatterIdNotBetween(String value1, String value2) {
            addCriterion("latter_id not between", value1, value2, "latterId");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNull() {
            addCriterion("video_id is null");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNotNull() {
            addCriterion("video_id is not null");
            return (Criteria) this;
        }

        public Criteria andVideoIdEqualTo(String value) {
            addCriterion("video_id =", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotEqualTo(String value) {
            addCriterion("video_id <>", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThan(String value) {
            addCriterion("video_id >", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThanOrEqualTo(String value) {
            addCriterion("video_id >=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThan(String value) {
            addCriterion("video_id <", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThanOrEqualTo(String value) {
            addCriterion("video_id <=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLike(String value) {
            addCriterion("video_id like", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotLike(String value) {
            addCriterion("video_id not like", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdIn(List<String> values) {
            addCriterion("video_id in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotIn(List<String> values) {
            addCriterion("video_id not in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdBetween(String value1, String value2) {
            addCriterion("video_id between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotBetween(String value1, String value2) {
            addCriterion("video_id not between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Date value) {
            addCriterion("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Date value) {
            addCriterion("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Date value) {
            addCriterion("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Date value) {
            addCriterion("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Date> values) {
            addCriterion("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Date> values) {
            addCriterion("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Date value1, Date value2) {
            addCriterion("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("upload_time not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}