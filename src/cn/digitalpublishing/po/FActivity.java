package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 02_流程节点信息
 * @table F_ACTIVITY
 */
@SuppressWarnings("serial")
public class FActivity implements Serializable {

	private String id; // 流程节点ID
	private String pdid; // 流程定义ID
	private String pdName; // 流程定义名称
	private String activityName; // 节点名称
	private String propCode; // 审批属性CODE
	private String type; // 流程类型
	private String assigneeCode; // 执行者编号
	private String startFlag; // 开始标识
	@JsonIgnore
	private Set<FActivityClassifyRelationship> activityClassifyRelationshipSet = new HashSet<FActivityClassifyRelationship>(); // 02_流程节点属性分类关联表
	@JsonIgnore
	private Set<FActivityPropRelationship> activityPropRelationshipSet = new HashSet<FActivityPropRelationship>(); // 02_流程节点属性关联表
	@JsonIgnore
	private Set<FCorpPersonActivityRelationship> corpPersonActivityRelationshipSet = new HashSet<FCorpPersonActivityRelationship>(); // 02_公司人员流程节点关系

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getPropCode() {
		return propCode;
	}

	public void setPropCode(String propCode) {
		this.propCode = propCode;
	}

	public Set<FActivityClassifyRelationship> getActivityClassifyRelationshipSet() {
		return activityClassifyRelationshipSet;
	}

	public void setActivityClassifyRelationshipSet(Set<FActivityClassifyRelationship> activityClassifyRelationshipSet) {
		this.activityClassifyRelationshipSet = activityClassifyRelationshipSet;
	}

	public Set<FActivityPropRelationship> getActivityPropRelationshipSet() {
		return activityPropRelationshipSet;
	}

	public void setActivityPropRelationshipSet(Set<FActivityPropRelationship> activityPropRelationshipSet) {
		this.activityPropRelationshipSet = activityPropRelationshipSet;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public String getAssigneeCode() {
        return assigneeCode;
    }

    public void setAssigneeCode(String assigneeCode) {
        this.assigneeCode = assigneeCode;
    }

    public String getStartFlag() {
        return startFlag;
    }

    public void setStartFlag(String startFlag) {
        this.startFlag = startFlag;
    }


	public Set<FCorpPersonActivityRelationship> getCorpPersonActivityRelationshipSet() {
		return corpPersonActivityRelationshipSet;
	}

	public void setCorpPersonActivityRelationshipSet(Set<FCorpPersonActivityRelationship> corpPersonActivityRelationshipSet) {
		this.corpPersonActivityRelationshipSet = corpPersonActivityRelationshipSet;
	}
}
