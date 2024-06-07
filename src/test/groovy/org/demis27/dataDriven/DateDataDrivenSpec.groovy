package org.demis27.dataDriven

import spock.lang.Specification

import java.time.LocalDate


class DateDataDrivenSpec extends Specification {

    def 'date plus one day'() {
        when: 'add a day'
        def result = input.plusDays(1)

        then: 'The result is as expected'
        result == expectedResult

        where: 'Inputs and expected results are'
        input                     || expectedResult
        LocalDate.of(2024, 6, 21) || LocalDate.of(2024, 6, 22)
        LocalDate.of(2024, 2, 28) || LocalDate.of(2024, 2, 29)
        LocalDate.of(2023, 2, 28) || LocalDate.of(2023, 3, 1)
    }

    def 'date plus one day #input and expected #expectedResult'() {
        when: 'add a day'
        def result = input.plusDays(1)

        then: 'The result is as expected'
        result == expectedResult

        where: 'Inputs and expected results are'
        input                     || expectedResult
        LocalDate.of(2024, 6, 21) || LocalDate.of(2024, 6, 22)
        LocalDate.of(2024, 2, 28) || LocalDate.of(2024, 2, 29)
        LocalDate.of(2023, 2, 28) || LocalDate.of(2023, 3, 1)
    }
}