package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.mapper.FinancialRecordMapper;
import io.unodevs.SoBarba.repository.FinancialRecordRepository;
import io.unodevs.SoBarba.repository.ProductRecordRepository;
import io.unodevs.SoBarba.repository.TaskRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialRecordService {
    @Autowired
    private FinancialRecordRepository financialRecordRepository;
    @Autowired
    private FinancialRecordMapper financialRecordMapper;
}
