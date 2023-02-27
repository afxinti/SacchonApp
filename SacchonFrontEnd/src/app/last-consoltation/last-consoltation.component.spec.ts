import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LastConsoltationComponent } from './last-consoltation.component';

describe('LastConsoltationComponent', () => {
  let component: LastConsoltationComponent;
  let fixture: ComponentFixture<LastConsoltationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LastConsoltationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LastConsoltationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
