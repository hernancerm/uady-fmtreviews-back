package hercerm.uady.fmtreviewsback.services.impl;

import com.google.gson.Gson;
import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceAggregatorDto;
import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceBookDto;
import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceVideoDto;
import hercerm.uady.fmtreviewsback.dtos.RecommendedResourceWebsiteDto;
import hercerm.uady.fmtreviewsback.entities.*;
import hercerm.uady.fmtreviewsback.errors.EntityNotFoundException;
import hercerm.uady.fmtreviewsback.mappers.impl.RecommendedResourceBookMapper;
import hercerm.uady.fmtreviewsback.mappers.impl.RecommendedResourceTypeMapper;
import hercerm.uady.fmtreviewsback.mappers.impl.RecommendedResourceVideoMapper;
import hercerm.uady.fmtreviewsback.mappers.impl.RecommendedResourceWebsiteMapper;
import hercerm.uady.fmtreviewsback.repositories.*;
import hercerm.uady.fmtreviewsback.services.RecommendedResourceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendedResourceServiceImpl implements RecommendedResourceService {

    private final RecommendedResourceBookRepository resourceBookRepository;
    private final RecommendedResourceVideoRepository resourceVideoRepository;
    private final RecommendedResourceWebsiteRepository resourceWebsiteRepository;
    private final RecommendedResourceTypeRepository resourceTypeRepository;
    private final CourseRepository courseRepository;

    private final RecommendedResourceBookMapper resourceBookMapper;
    private final RecommendedResourceVideoMapper resourceVideoMapper;
    private final RecommendedResourceWebsiteMapper resourceWebsiteMapper;
    private final RecommendedResourceTypeMapper resourceTypeMapper;

    private final Gson gson;

    public RecommendedResourceServiceImpl(RecommendedResourceBookRepository resourceBookRepository,
                                          RecommendedResourceVideoRepository resourceVideoRepository,
                                          RecommendedResourceWebsiteRepository resourceWebsiteRepository,
                                          RecommendedResourceTypeRepository resourceTypeRepository,
                                          CourseRepository courseRepository,

                                          RecommendedResourceBookMapper resourceBookMapper,
                                          RecommendedResourceVideoMapper resourceVideoMapper,
                                          RecommendedResourceWebsiteMapper resourceWebsiteMapper,
                                          RecommendedResourceTypeMapper resourceTypeMapper,

                                          Gson gson) {
        this.resourceBookRepository = resourceBookRepository;
        this.resourceVideoRepository = resourceVideoRepository;
        this.resourceWebsiteRepository = resourceWebsiteRepository;
        this.resourceTypeRepository = resourceTypeRepository;
        this.courseRepository = courseRepository;

        this.resourceBookMapper = resourceBookMapper;
        this.resourceVideoMapper = resourceVideoMapper;
        this.resourceWebsiteMapper = resourceWebsiteMapper;
        this.resourceTypeMapper = resourceTypeMapper;

        this.gson = gson;
    }

    // TODO: Refactor to avoid repeated code.
    @Override
    public List<RecommendedResourceAggregatorDto<?>> getByCourseId(Long courseId) {
        List<RecommendedResourceAggregatorDto<?>> recommendedResources = new ArrayList<>();

        courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        // Books
        RecommendedResourceAggregatorDto<RecommendedResourceBookDto> recommendedBooksAggregator =
                new RecommendedResourceAggregatorDto<>();

        List<RecommendedResourceBookDto> recommendedBooks = resourceBookRepository.findByCourseId(courseId).stream()
                .map(book -> {
                    RecommendedResourceBookDto bookDto = resourceBookMapper.entity2dto(book);
                    bookDto.setCourse(null);
                    bookDto.setType(null);
                    return bookDto;
                })
                .collect(Collectors.toList());

        recommendedBooksAggregator.setResources(recommendedBooks);
        recommendedBooksAggregator.setType(resourceTypeMapper.entity2dto(
                resourceTypeRepository.findByName(RecommendedResourceType.BOOK)
                        .orElseThrow(() -> new EntityNotFoundException("Recommended resource type not found"))));

        recommendedResources.add(recommendedBooksAggregator);

        // Videos
        RecommendedResourceAggregatorDto<RecommendedResourceVideoDto> recommendedVideosAggregator =
                new RecommendedResourceAggregatorDto<>();

        List<RecommendedResourceVideoDto> recommendedVideos = resourceVideoRepository.findByCourseId(courseId).stream()
                .map(video -> {
                    RecommendedResourceVideoDto videoDto = resourceVideoMapper.entity2dto(video);
                    videoDto.setCourse(null);
                    videoDto.setType(null);
                    return videoDto;
                })
                .collect(Collectors.toList());

        recommendedVideosAggregator.setResources(recommendedVideos);
        recommendedVideosAggregator.setType(resourceTypeMapper.entity2dto(
                resourceTypeRepository.findByName(RecommendedResourceType.VIDEO)
                        .orElseThrow(() -> new EntityNotFoundException("Recommended resource type not found"))));

        recommendedResources.add(recommendedVideosAggregator);

        // Websites
        RecommendedResourceAggregatorDto<RecommendedResourceWebsiteDto> recommendedWebsitesAggregator =
                new RecommendedResourceAggregatorDto<>();

        List<RecommendedResourceWebsiteDto> recommendedWebsites = resourceWebsiteRepository.findByCourseId(courseId).stream()
                .map(website -> {
                    RecommendedResourceWebsiteDto websiteDto = resourceWebsiteMapper.entity2dto(website);
                    websiteDto.setCourse(null);
                    websiteDto.setType(null);
                    return websiteDto;
                })
                .collect(Collectors.toList());

        recommendedWebsitesAggregator.setResources(recommendedWebsites);
        recommendedWebsitesAggregator.setType(resourceTypeMapper.entity2dto(
                resourceTypeRepository.findByName(RecommendedResourceType.WEBSITE)
                        .orElseThrow(() -> new EntityNotFoundException("Recommended resource type not found"))));

        recommendedResources.add(recommendedWebsitesAggregator);

        return recommendedResources;
    }

/*
 * Unsuccessful attempt to avoid repeated code in getByCourseId.
 * Code might have to be re-thought before generalizing.
 * */
//    private RecommendedResourceAggregatorDto<?> buildRecommendedResourceAggregatorDtoForCourse(
//            Long courseId,
//            RecommendedResourceRepository<?> resourceRepository,
//            EntityDtoMapper<?, ? extends RecommendedResourceDto> resourceMapper,
//            String resourceTypeName) {
//
//        RecommendedResourceAggregatorDto<RecommendedResourceDto> recommendedResourceAggregator =
//                new RecommendedResourceAggregatorDto<>();
//
//        List<RecommendedResourceDto> recommendedResources = resourceRepository.findByCourseId(courseId).stream()
//                .map(resource -> {
//                    RecommendedResourceDto resourceDto = resourceMapper.entity2dto(resource);
//                    resourceDto.setCourse(null);
//                    resourceDto.setType(null);
//                    return resourceDto;
//                })
//                .collect(Collectors.toList());
//
//        recommendedResourceAggregator.setResources(recommendedResources);
//        recommendedResourceAggregator.setType(resourceTypeMapper.entity2dto(
//                resourceTypeRepository.findByName(resourceTypeName)
//                        .orElseThrow(() -> new EntityNotFoundException("Recommended resource type not found"))));
//
//        return recommendedResourceAggregator;
//    }

    @Override
    public Object create(String recommendedResourceDtoJson, String recommendedResourceTypeName, Long courseId) {
        Object savedRecommendedResourceDto = null;

        RecommendedResourceType fetchedResourceType =
                resourceTypeRepository.findByName(recommendedResourceTypeName)
                        .orElseThrow(() -> new EntityNotFoundException("Recommended resource type not found"));

        Course fetchedCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        // TODO: Validate DTOs mapped by Gson.
        // TODO: Refactor to avoid repeated code.
        switch (recommendedResourceTypeName) {
            case RecommendedResourceType.BOOK:
                RecommendedResourceBookDto resourceBookDto =
                        gson.fromJson(recommendedResourceDtoJson, RecommendedResourceBookDto.class);
                RecommendedResourceBook resourceBook = resourceBookMapper.dto2entity(resourceBookDto);
                resourceBook.setType(fetchedResourceType);
                resourceBook.setCourse(fetchedCourse);
                savedRecommendedResourceDto = resourceBookMapper.entity2dto(resourceBookRepository.save(resourceBook));
                break;
            case RecommendedResourceType.VIDEO:
                RecommendedResourceVideoDto resourceVideoDto =
                        gson.fromJson(recommendedResourceDtoJson, RecommendedResourceVideoDto.class);
                RecommendedResourceVideo resourceVideo = resourceVideoMapper.dto2entity(resourceVideoDto);
                resourceVideo.setType(fetchedResourceType);
                resourceVideo.setCourse(fetchedCourse);
                savedRecommendedResourceDto = resourceVideoMapper.entity2dto(resourceVideoRepository.save(resourceVideo));
                break;
            case RecommendedResourceType.WEBSITE:
                RecommendedResourceWebsiteDto resourceWebsiteDto =
                        gson.fromJson(recommendedResourceDtoJson, RecommendedResourceWebsiteDto.class);
                RecommendedResourceWebsite resourceWebsite = resourceWebsiteMapper.dto2entity(resourceWebsiteDto);
                resourceWebsite.setType(fetchedResourceType);
                resourceWebsite.setCourse(fetchedCourse);
                savedRecommendedResourceDto = resourceWebsiteMapper.entity2dto(resourceWebsiteRepository.save(resourceWebsite));
                break;
        }

        return savedRecommendedResourceDto;
    }
}
