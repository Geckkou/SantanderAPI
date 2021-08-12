package com.project.santanderdevweek.ApiSantander.service;

import com.project.santanderdevweek.ApiSantander.exceptions.BusinessException;
import com.project.santanderdevweek.ApiSantander.exceptions.NotFoundException;
import com.project.santanderdevweek.ApiSantander.mapper.StockMapper;
import com.project.santanderdevweek.ApiSantander.model.Stock;
import com.project.santanderdevweek.ApiSantander.model.dto.StockDTO;
import com.project.santanderdevweek.ApiSantander.repository.StockRepository;
import com.project.santanderdevweek.ApiSantander.util.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StockService {


    private StockRepository repository;
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {

        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());

        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDTO(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());

        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDTO(stock);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);

        repository.deleteById(dto.getId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(NotFoundException::new);
    }
    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return repository.findByToday()
                .map(mapper::toDTO)
                .orElseThrow(NotFoundException::new);
    }
}
