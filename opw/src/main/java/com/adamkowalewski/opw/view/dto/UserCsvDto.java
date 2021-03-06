/*
 * The MIT License
 *
 * Copyright 2015 Adam Kowalewski.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.adamkowalewski.opw.view.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO used for CSV import of user accounts.
 *
 * @author Adam Kowalewski
 */
public class UserCsvDto {

    private String firstname;
    private String lastname;
    private String email;
    private String type;
    private List<String> obwodowaList;

    private boolean duplicate;

    public UserCsvDto() {
        obwodowaList = new ArrayList<>();
    }

    public UserCsvDto(String firstname, String lastname, String email, String type, List<String> obwodowaList) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.type = type;
        this.obwodowaList = obwodowaList;
    }

    public UserCsvDto(String firstname, String lastname, String email, String type, List<String> obwodowaList, boolean duplicate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.type = type;
        this.obwodowaList = obwodowaList;
        this.duplicate = duplicate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getObwodowaList() {
        return obwodowaList;
    }

    public void setObwodowaList(List<String> obwodowaList) {
        this.obwodowaList = obwodowaList;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("firstname", firstname)
                .add("lastname", lastname)
                .add("email", email)
                .add("type", type)
                .add("obwodowaList", obwodowaList)
                .add("duplicate", duplicate)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCsvDto that = (UserCsvDto) o;
        return Objects.equal(duplicate, that.duplicate)
                && Objects.equal(email, that.email)
                && Objects.equal(firstname, that.firstname)
                && Objects.equal(obwodowaList, that.obwodowaList)
                && Objects.equal(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstname, lastname, email, type, obwodowaList, duplicate);
    }
}
