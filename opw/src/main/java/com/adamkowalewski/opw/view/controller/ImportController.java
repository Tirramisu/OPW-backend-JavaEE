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
package com.adamkowalewski.opw.view.controller;

import com.adamkowalewski.opw.entity.OpwObwodowaKomisja;
import com.adamkowalewski.opw.entity.OpwOkregowaKomisja;
import com.adamkowalewski.opw.view.dto.OkregowaCsvDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;


import com.adamkowalewski.opw.view.dto.UserCsvDto;
import static com.adamkowalewski.opw.view.controller.csv.OkregowaCsvDtoReader.okregowaCsvDtoReader;

/**
 * Provides reusable logic for file import.
 *
 * @author Adam Kowalewski
 */
@Named
@RequestScoped
public class ImportController implements Serializable {

    @Inject
    OkregowaController okregowaController;

    public void performImport(List<OkregowaCsvDto> okregowaList) {
        List<OpwOkregowaKomisja> resultList = new ArrayList<>();

        for (OkregowaCsvDto csvDto : okregowaList) {
            OpwOkregowaKomisja single = new OpwOkregowaKomisja();
            single.setPkwId(csvDto.getPkwId());
            single.setName(csvDto.getName());
            resultList.add(single);
        }

        okregowaController.create(resultList);
    }

    /**
     * Converts CSV content into list of DTO instances.
     *
     * @param content stream as uploaded.
     * @return clean instances.
     * @throws IOException
     * @throws IndexOutOfBoundsException
     * @throws PatternSyntaxException
     * @throws NumberFormatException
     * @author Adam Kowalewski
     * @version 2015.04.06
     */
    public List<OkregowaCsvDto> parseOkregowa(InputStream content)
            throws IOException, IndexOutOfBoundsException, NumberFormatException, PatternSyntaxException {

        List<OkregowaCsvDto> result = okregowaCsvDtoReader().readAllFrom(content);

        // TODO check duplicates
        return result;
    }

    /**
     * TODO OPW-A-6
     *
     * @MOCK
     * @param userList
     */
    public void performImportUser(List<UserCsvDto> userList) {
        System.out.println("MOCK!");
    }

    /**
     * TODO OPW-A-6
     *
     * @MOCK!
     * @param content
     * @return
     */
    public List<UserCsvDto> parseUser(InputStream content) {
        List<UserCsvDto> result = new ArrayList<>();
        result.add(new UserCsvDto("Marek", "Saganowski", "ms@openpkw.pl", "O", new ArrayList<OpwObwodowaKomisja>(), false));
        result.add(new UserCsvDto("Robert", "Saganowski", "rs@openpkw.pl", "O", new ArrayList<OpwObwodowaKomisja>(), false));
        return result;
    }
}
