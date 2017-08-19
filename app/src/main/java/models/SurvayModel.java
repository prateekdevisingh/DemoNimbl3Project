package models;

import java.io.Serializable;

/**
 * Created by Prateek on 10/08/17.
 */


/**
 * This is model class which provide serialization in objects and act as POJO class
 */
public class SurvayModel implements Serializable {
    String access_code_prompt;
    String access_code_validation;
    String active_at;
    String cover_background_color;
    String cover_image_url;
    String created_at;
    String default_language;
    String description;
    String footer_content;
    String id;
    String inactive_at;
    boolean is_access_code_required;
    boolean is_access_code_valid_required;
    boolean is_active;
    String language_list;
    String questions;
    String short_url;
    String survey_version;
    String tag_list;
    String thank_email_above_threshold;
    String thank_email_below_threshold;
    String theme;
    String title;
    String type;


    public SurvayModel(String access_code_prompt, String access_code_validation, String active_at, String cover_background_color, String cover_image_url, String created_at, String default_language, String description, String footer_content, String id, String inactive_at, boolean is_access_code_required, boolean is_access_code_valid_required, boolean is_active, String language_list, String questions, String short_url, String survey_version, String tag_list, String thank_email_above_threshold, String thank_email_below_threshold, String theme, String title, String type) {
        this.access_code_prompt = access_code_prompt;
        this.access_code_validation = access_code_validation;
        this.active_at = active_at;
        this.cover_background_color = cover_background_color;
        this.cover_image_url = cover_image_url;
        this.created_at = created_at;
        this.default_language = default_language;
        this.description = description;
        this.footer_content = footer_content;
        this.id = id;
        this.inactive_at = inactive_at;
        this.is_access_code_required = is_access_code_required;
        this.is_access_code_valid_required = is_access_code_valid_required;
        this.is_active = is_active;
        this.language_list = language_list;
        this.questions = questions;
        this.short_url = short_url;
        this.survey_version = survey_version;
        this.tag_list = tag_list;
        this.thank_email_above_threshold = thank_email_above_threshold;
        this.thank_email_below_threshold = thank_email_below_threshold;
        this.theme = theme;
        this.title = title;
        this.type = type;
    }

    public String getAccess_code_prompt() {
        return access_code_prompt;
    }

    public void setAccess_code_prompt(String access_code_prompt) {
        this.access_code_prompt = access_code_prompt;
    }

    public String getAccess_code_validation() {
        return access_code_validation;
    }

    public void setAccess_code_validation(String access_code_validation) {
        this.access_code_validation = access_code_validation;
    }

    public String getActive_at() {
        return active_at;
    }

    public void setActive_at(String active_at) {
        this.active_at = active_at;
    }

    public String getCover_background_color() {
        return cover_background_color;
    }

    public void setCover_background_color(String cover_background_color) {
        this.cover_background_color = cover_background_color;
    }

    public String getCover_image_url() {
        return cover_image_url;
    }

    public void setCover_image_url(String cover_image_url) {
        this.cover_image_url = cover_image_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDefault_language() {
        return default_language;
    }

    public void setDefault_language(String default_language) {
        this.default_language = default_language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFooter_content() {
        return footer_content;
    }

    public void setFooter_content(String footer_content) {
        this.footer_content = footer_content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInactive_at() {
        return inactive_at;
    }

    public void setInactive_at(String inactive_at) {
        this.inactive_at = inactive_at;
    }

    public boolean is_access_code_required() {
        return is_access_code_required;
    }

    public void setIs_access_code_required(boolean is_access_code_required) {
        this.is_access_code_required = is_access_code_required;
    }

    public boolean is_access_code_valid_required() {
        return is_access_code_valid_required;
    }

    public void setIs_access_code_valid_required(boolean is_access_code_valid_required) {
        this.is_access_code_valid_required = is_access_code_valid_required;
    }

    public boolean is_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getLanguage_list() {
        return language_list;
    }

    public void setLanguage_list(String language_list) {
        this.language_list = language_list;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public String getSurvey_version() {
        return survey_version;
    }

    public void setSurvey_version(String survey_version) {
        this.survey_version = survey_version;
    }

    public String getTag_list() {
        return tag_list;
    }

    public void setTag_list(String tag_list) {
        this.tag_list = tag_list;
    }

    public String getThank_email_above_threshold() {
        return thank_email_above_threshold;
    }

    public void setThank_email_above_threshold(String thank_email_above_threshold) {
        this.thank_email_above_threshold = thank_email_above_threshold;
    }

    public String getThank_email_below_threshold() {
        return thank_email_below_threshold;
    }

    public void setThank_email_below_threshold(String thank_email_below_threshold) {
        this.thank_email_below_threshold = thank_email_below_threshold;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
