import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecordingsProgressComponent } from './recordings-progress.component';

describe('RecordingsProgressComponent', () => {
  let component: RecordingsProgressComponent;
  let fixture: ComponentFixture<RecordingsProgressComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecordingsProgressComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecordingsProgressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
