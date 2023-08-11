/**
 * Author : PhearunPhin
 * Date : 7/26/2023
 */

package com.phearun.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@Builder
public class PaginationDTO {
    private int numberOfElements;
    private int number;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean empty;
    private boolean first;
    private boolean last;

}
