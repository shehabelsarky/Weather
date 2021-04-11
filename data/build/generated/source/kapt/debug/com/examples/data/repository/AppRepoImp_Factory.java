package com.examples.data.repository;

import com.examples.data.source.cloud.BaseCloudRepository;
import com.examples.data.source.db.AppCitiesDatabase;
import com.examples.data.source.local.MockJson;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppRepoImp_Factory implements Factory<AppRepoImp> {
  private final Provider<BaseCloudRepository> cloudRepositoryProvider;

  private final Provider<AppCitiesDatabase> citiesDatabaseProvider;

  private final Provider<MockJson> mockJsonProvider;

  public AppRepoImp_Factory(Provider<BaseCloudRepository> cloudRepositoryProvider,
      Provider<AppCitiesDatabase> citiesDatabaseProvider, Provider<MockJson> mockJsonProvider) {
    this.cloudRepositoryProvider = cloudRepositoryProvider;
    this.citiesDatabaseProvider = citiesDatabaseProvider;
    this.mockJsonProvider = mockJsonProvider;
  }

  @Override
  public AppRepoImp get() {
    return newInstance(cloudRepositoryProvider.get(), citiesDatabaseProvider.get(), mockJsonProvider.get());
  }

  public static AppRepoImp_Factory create(Provider<BaseCloudRepository> cloudRepositoryProvider,
      Provider<AppCitiesDatabase> citiesDatabaseProvider, Provider<MockJson> mockJsonProvider) {
    return new AppRepoImp_Factory(cloudRepositoryProvider, citiesDatabaseProvider, mockJsonProvider);
  }

  public static AppRepoImp newInstance(BaseCloudRepository cloudRepository,
      AppCitiesDatabase citiesDatabase, MockJson mockJson) {
    return new AppRepoImp(cloudRepository, citiesDatabase, mockJson);
  }
}
