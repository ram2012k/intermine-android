package org.intermine.app.core.templates;

/*
 * Copyright (C) 2015 InterMine
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  See the LICENSE file for more
 * information or http://www.gnu.org/copyleft/lesser.html.
 *
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.intermine.app.core.model.Model;
import org.intermine.app.core.templates.constraint.Constraint;

import java.util.List;

/**
 * @author Daria Komkova <Daria_Komkova @ hotmail.com>
 */
public class Template implements Parcelable {
    @SerializedName("model")
    private Model mModel;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("name")
    private String mName;

    @SerializedName("comment")
    private String mComment;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("select")
    private java.util.List<String> mColumns;

    @SerializedName("values")
    private java.util.List<String> mValues;

    @SerializedName("where")
    private List<Constraint> mConstraints;

    protected Template(Parcel in) {
        mTitle = in.readString();
        mName = in.readString();
        mComment = in.readString();
        mDescription = in.readString();
        mColumns = in.readArrayList(null);
        mConstraints = in.readArrayList(Constraint.class.getClassLoader());
        mValues = in.readArrayList(null);
    }

    public Template() {

    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public List<String> getColumns() {
        return mColumns;
    }

    public void setColumns(List<String> columns) {
        mColumns = columns;
    }

    public List<Constraint> getConstraints() {
        return mConstraints;
    }

    public void setConstraints(List<Constraint> constraints) {
        mConstraints = constraints;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<String> getmValues() {
        return mValues;
    }

    public void setmValues(List<String> mValues) {
        this.mValues = mValues;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }

    public Model getModel() {
        return mModel;
    }

    public void setModel(Model model) {
        mModel = model;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mName);
        dest.writeString(mComment);
        dest.writeString(mDescription);
        dest.writeList(mColumns);
        dest.writeList(mConstraints);
        dest.writeList(mValues);
    }

    public static final Creator<Template> CREATOR = new Creator<Template>() {
        @Override
        public Template createFromParcel(Parcel in) {
            return new Template(in);
        }

        @Override
        public Template[] newArray(int size) {
            return new Template[size];
        }
    };
}

