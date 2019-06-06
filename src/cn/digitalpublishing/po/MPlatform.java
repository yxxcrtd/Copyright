package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 06_推送平台
 * @table M_PLATFORM
 */
@SuppressWarnings("serial")
public class MPlatform implements Serializable {

	private String id; // 推送平台ID
	private String name; // 推送平台名称
    private String app_key;// 申请应用时分配的app_key
    private String app_secret;//申请应用时分配到的app_secret
    private String redirectUri;// 授权回调地址
    private String authorizeCode;//用来换取accessToken的授权码
    private String accessToken;
    private String expiresIn;//accessToken过期时间
    private String refreshToken;//刷新token
    private String openid;//用户统一标识
    private String openkey;

	@JsonIgnore
	private Set<MPromotion> promotionSet = new HashSet<MPromotion>(); // 06_推送信息

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MPromotion> getPromotionSet() {
		return promotionSet;
	}

	public void setPromotionSet(Set<MPromotion> promotionSet) {
		this.promotionSet = promotionSet;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getApp_key() {
		return app_key;
	}

	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}

	public String getApp_secret() {
		return app_secret;
	}

	public void setApp_secret(String app_secret) {
		this.app_secret = app_secret;
	}

	public String getAuthorizeCode() {
		return authorizeCode;
	}

	public void setAuthorizeCode(String authorizeCode) {
		this.authorizeCode = authorizeCode;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOpenkey() {
		return openkey;
	}

	public void setOpenkey(String openkey) {
		this.openkey = openkey;
	}

	public MPlatform(String id, String name, String app_key, String app_secret,
			String redirectUri, String authorizeCode, String accessToken,
			String expiresIn, String refreshToken, String openid,
			String openkey, Set<MPromotion> promotionSet) {
		super();
		this.id = id;
		this.name = name;
		this.app_key = app_key;
		this.app_secret = app_secret;
		this.redirectUri = redirectUri;
		this.authorizeCode = authorizeCode;
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
		this.refreshToken = refreshToken;
		this.openid = openid;
		this.openkey = openkey;
		this.promotionSet = promotionSet;
	}

	public MPlatform(){}
}
