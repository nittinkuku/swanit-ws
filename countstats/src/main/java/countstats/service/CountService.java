package countstats.service;

import countstats.model.Count;
import countstats.repository.CountRepository;
import org.springframework.stereotype.Service;

@Service
public class CountService {
    private CountRepository countRepository;

    public CountService(CountRepository countRepository) {
        this.countRepository = countRepository;
    }

    public Count saveCount(Count count) {
        return countRepository.save(count);
    }

    public Iterable<Count> getAllCounts() {
        return countRepository.findAll();
    }

    public Long getCountForProcess(String process, String study) {
        return countRepository.getCountForProcess(process, study);
    }
}