import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildSimComponent } from './build-sim-component';

describe('Character', () => {
  let component: BuildSimComponent;
  let fixture: ComponentFixture<BuildSimComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuildSimComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(BuildSimComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
