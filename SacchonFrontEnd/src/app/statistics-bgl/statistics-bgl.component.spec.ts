import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticsBglComponent } from './statistics-bgl.component';

describe('StatisticsBglComponent', () => {
  let component: StatisticsBglComponent;
  let fixture: ComponentFixture<StatisticsBglComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatisticsBglComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatisticsBglComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
